package cool.happycoding.code.user;

import cool.happycoding.code.base.user.UserContextService;
import cool.happycoding.code.user.context.UserContextLoadInnerFilter;
import cool.happycoding.code.user.filter.UserContextLoadFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.OrderComparator;

import java.util.List;

/**
 * <p>
 *     用户上下文配置
 * </p>
 *
 * @author lanlanhappy 2020/12/03 9:10 下午
 */
@Configuration
@EnableConfigurationProperties(UserContextProperties.class)
public class HappyUserAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public UserContextService userContextService(UserContextProperties userContextProperties){
        return new DefaultUserContextService(userContextProperties);
    }

    @Bean
    public FilterRegistrationBean<UserContextLoadFilter> filterRegistrationBean(UserContextService userContextService,
                                                                                UserContextProperties userContextProperties){
        FilterRegistrationBean<UserContextLoadFilter> registrationBean = new FilterRegistrationBean<>();
        UserInnerFilter userInnerFilter = new UserContextLoadInnerFilter(userContextService, userContextProperties);
        registrationBean.setFilter(new UserContextLoadFilter(userInnerFilter));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("userContextLoadFilter");
        registrationBean.setOrder(userContextProperties.getFilterOrder());
        return registrationBean;
    }


}
