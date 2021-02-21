package cool.happycoding.code.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description
 *
 * @author lanlanhappy 2021/02/21 11:37 上午
 */
@Data
@ConfigurationProperties(prefix = HappyCacheProperties.HAPPY_CACHE_PREFIX)
public class HappyCacheProperties {

    public static final String HAPPY_CACHE_PREFIX = "happy.code.cache";

    /**
     * @Cached和@CreateCache自动生成name的时候，为了不让name太长，hiddenPackages指定的包名前缀被截掉
     */
    private String[] hiddenPackages;
    /**
     * 统计间隔，0表示不统计
     */
    private int statIntervalMinutes = 0;
    /**
     * 开启方法缓存
     */
    private boolean enableMethodCache = true;

    /**
     * key转换器的全局配置
     */
    private String keyConvertor = "fastjson";

    /**
     * 每个缓存实例的最大元素的全局配置 默认100,仅local 缓存需要指定
     */
    private long localDefaultLimit = 100;

    /**
     * 以毫秒为单位，指定多长时间没有访问，就让缓存失效，当前只有本地缓存支持。0表示不使用这个功能
     */
    private long localDefaultExpireAfterAccessInMillis = 0;

    /**
     * 本地缓存过期配置，此配置为全局配置，优先级最低，只在cache定义上未过期时间时采用
     */
    private long localDefaultExpireAfterWriteInMillis = 0;

    /**
     * 远程缓存过期配置，此配置为全局配置，优先级最低，只在cache定义上未过期时间时采用
     */
    private long remoteDefaultExpireAfterWriteInMillis = 0;

    /**
     * cache type 为 both 时 所需配置，一般不需要应用配置，采用默认即可
     */
    private String bothCacheSyncTopic = "both-cache-sync";

}
