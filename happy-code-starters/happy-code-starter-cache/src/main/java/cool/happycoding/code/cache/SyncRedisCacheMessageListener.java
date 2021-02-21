package cool.happycoding.code.cache;

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.support.CacheMessage;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;

/**
 * <p>监听缓存变化的同步事件，清除相应的local cache，以实现local cache的同步</p>
 *
 * @author lanlanhappy 2021/02/21 6:00 下午
 */
@Slf4j
public class SyncRedisCacheMessageListener implements MessageListener {

    private final SpringConfigProvider springConfigProvider;
    private final SyncCachePostProcessor syncCachePostProcessor;
    private final StringRedisTemplate stringRedisTemplate;

    public SyncRedisCacheMessageListener(SpringConfigProvider springConfigProvider, SyncCachePostProcessor syncCachePostProcessor,
                                         StringRedisTemplate stringRedisTemplate){
        this.springConfigProvider = springConfigProvider;
        this.syncCachePostProcessor = syncCachePostProcessor;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = stringRedisTemplate.getStringSerializer().deserialize(message.getBody());
        consumeMessage(msg);
    }

    @SuppressWarnings("unchecked")
    private void consumeMessage(String message) {
        log.info("syncCacheMessage:{}", message);
        try {
            SyncCacheMessage syncCacheMessage = SyncCacheMessage.syncCacheMessage(message);
            boolean isSelf = StrUtil.equalsAnyIgnoreCase(syncCacheMessage.getProducerAddr(), SystemUtil.getHostInfo().getAddress());
            // 排除当前机器
            if (!isSelf) {
                CacheMessage cacheMessage = syncCacheMessage.getCacheMessage();
                Cache<String, String> cache = (Cache<String, String>) springConfigProvider
                        .getCacheManager()
                        .getCache(syncCacheMessage.getArea(), syncCacheMessage.getCacheName())
                        .unwrap(Cache.class);
                switch (cacheMessage.getType()) {
                    case CacheMessage.TYPE_PUT:
                    case CacheMessage.TYPE_REMOVE:
                        Arrays.stream(cacheMessage.getKeys())
                                .map(StrUtil::toString)
                                .filter(StrUtil::isNotBlank)
                                .forEach(cache::invalidate);
                        break;
                    case CacheMessage.TYPE_REMOVE_ALL:
                        cache.invalidateAll();
                        break;
                    default:
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            // 第一次同步时cache有可能没有初始化，因此会出现异常：cache definition not found: xxxx
            log.warn("sync cache error:{}", e.getMessage());
        } finally {
            // 后置处理调用
            syncCachePostProcessor.post(springConfigProvider, message);
        }
    }
}
