package cool.happycoding.code.lock;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author lanlanhappy 2021/04/28 7:40 下午
 */
@Configuration
@EnableConfigurationProperties({HappyLockProperties.class})
public class HappyLockAutoConfiguration {
}
