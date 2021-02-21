package cool.happycoding.code.cache;

import cn.hutool.system.SystemUtil;
import com.alibaba.fastjson.JSON;
import com.alicp.jetcache.support.CacheMessage;
import com.alicp.jetcache.support.CacheMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * <p>实现 jetcache 缓存更新时事件，并通过redis进行广播，以当 cacheType为Both时 jetcache 的两级缓存刷新问题</p>
 *
 * @author lanlanhappy 2021/02/21 6:01 下午
 */
@Slf4j
public class SyncRedisCacheMessagePublisher implements CacheMessagePublisher {

    private final HappyCacheProperties happyCacheProperties;
    private final StringRedisTemplate stringRedisTemplate;
    public SyncRedisCacheMessagePublisher(HappyCacheProperties happyCacheProperties, StringRedisTemplate stringRedisTemplate){
        this.happyCacheProperties = happyCacheProperties;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void publish(String area, String cacheName, CacheMessage cacheMessage) {
        log.info("cache remove area: {}, cacheName: {}, message: {}", area, cacheName, JSON.toJSONString(cacheMessage));
        stringRedisTemplate.convertAndSend(happyCacheProperties.getBothCacheSyncTopic(),
                SyncCacheMessage
                        .builder()
                        .area(area)
                        .cacheName(cacheName)
                        .timestamp(System.currentTimeMillis())
                        .producerAddr(SystemUtil.getHostInfo().getAddress())
                        .cacheMessage(cacheMessage)
                        .build().toJSONString());
    }



}