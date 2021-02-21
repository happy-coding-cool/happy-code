package cool.happycoding.code.cache;

import com.alicp.jetcache.anno.support.SpringConfigProvider;

/**
 * <p>本地缓存同步监听后置处理器</p>
 *
 * @author lanlanhappy 2021/02/21 6:01 下午
 */
public interface SyncCachePostProcessor {

    /**
     * 后置处理
     * @param springConfigProvider
     * @param message
     */
    void post(SpringConfigProvider springConfigProvider, String message);
}
