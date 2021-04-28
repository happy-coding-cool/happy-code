package cool.happycoding.code.lock;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.concurrent.TimeUnit;

/**
 * lock 配置类
 *
 * @author liuzewei 2021/04/06 10:04
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = HappyLockProperties.BN_LOCK_PREFIX)
public class HappyLockProperties {

    public static final String BN_LOCK_PREFIX = "happy.code.lock";

    /**
     * 默认等待时间  超过则不在获取锁
     */
    private Integer waitTime = 0;

    /**
     * 默认释放锁时间 30秒
     */
    private Integer leaseTime = 30000;

    /**
     * 时间粒度 单位默认为秒
     */
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;

}
