package cool.happycoding.code.cache;

import com.alicp.jetcache.anno.support.SpringConfigProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author lanlanhappy 2021/02/21 6:01 下午
 */
@Slf4j
public class NoneSyncCachePostProcessor implements SyncCachePostProcessor{

    @Override
    public void post(SpringConfigProvider springConfigProvider, String message) {
        log.info("NoneSyncCachePostProcessor post");
    }
}
