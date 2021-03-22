package cool.happycoding.code.web;

import com.google.common.collect.Maps;
import cool.happycoding.code.base.HappyCodeVersion;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/03/22 3:10 下午
 */
public class HappyCodeVersionListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        Map<String, Object> version = Maps.newHashMap();
        version.put("happy-code.version", HappyCodeVersion.getVersion());
        MapPropertySource propertySource = new MapPropertySource("happy-code.version", version);
        environment.getPropertySources().addLast(propertySource);
    }
}
