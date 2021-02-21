package cool.happycoding.code.cache;

import com.alicp.jetcache.autoconfigure.JetCacheAutoConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * description
 *
 * @author lanlanhappy 2021/02/21 11:31 上午
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(HappyCacheProperties.class)
@PropertySource({"classpath:happy-jetcache.properties"})
@AutoConfigureBefore({JetCacheAutoConfiguration.class})
public class HappyCacheAutoConfiguration {

}
