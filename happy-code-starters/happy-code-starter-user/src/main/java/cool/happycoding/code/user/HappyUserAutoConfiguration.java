package cool.happycoding.code.user;

import cool.happycoding.code.base.user.UserContextService;
import cool.happycoding.code.base.user.UserDetailService;
import cool.happycoding.code.user.context.UserContextLoadInnerFilter;
import cool.happycoding.code.user.filter.UserContextLoadFilter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.OrderComparator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class HappyUserAutoConfiguration implements WebMvcConfigurer {


    @Bean
    @ConditionalOnMissingBean
    public UserContextService userContextService(UserContextProperties userContextProperties){
        return new DefaultUserContextService(userContextProperties);
    }



    @Bean
    public UserInnerFilter userInnerFilter(UserContextService userContextService,
                                           UserContextProperties userContextProperties){
        return new UserContextLoadInnerFilter(userContextService, userContextProperties);
    }

    @Bean
    public FilterRegistrationBean<UserContextLoadFilter> filterRegistrationBean(ObjectProvider<List<UserInnerFilter>> userInnerFilterProvider,
                                                                                UserContextProperties userContextProperties){
        FilterRegistrationBean<UserContextLoadFilter> registrationBean = new FilterRegistrationBean<>();
        List<UserInnerFilter> userInnerFilters = userInnerFilterProvider.getIfAvailable();
        if (userInnerFilters != null) {
            OrderComparator.sort(userInnerFilters);
        }
        registrationBean.setFilter(new UserContextLoadFilter(userInnerFilters));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("userContextLoadFilter");
        registrationBean.setOrder(userContextProperties.getFilterOrder());
        return registrationBean;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserContextMethodArgumentResolver());
    }

}
