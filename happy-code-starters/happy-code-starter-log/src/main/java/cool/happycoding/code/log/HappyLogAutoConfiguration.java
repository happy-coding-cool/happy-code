package cool.happycoding.code.log;

import cool.happycoding.code.log.filter.MdcParamFilter;
import cool.happycoding.code.log.filter.TimeIntervalFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * description
 * TRACE < DEBUG < INFO <  WARN < ERROR
 * 日志级别越低意味着打印的日志量越大，如：
 * 设置为：
 *  TRACE时，级别为：TRACE、DEBUG、INFO、WARN、ERROR 会被打印
 *  DEBUG时，级别为：DEBUG、INFO、WARN、ERROR 会被打印
 *  INFO时，级别为：INFO、WARN、ERROR 会被打印
 *  WARN时，级别为：WARN、ERROR 会被打印
 *  ERROR时，级别为：ERROR 会被打印
 * @author lanlanhappy 2020/12/06 11:33 上午
 */
@Configuration
@EnableConfigurationProperties(HappyLogProperties.class)
public class HappyLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MdcParamCollector mdcParamCollector(){
        return new DefaultMdcParamCollector();
    }

    @Bean
    public FilterRegistrationBean<MdcParamFilter> mdcParamFilter(MdcParamCollector mdcParamCollector) {
        FilterRegistrationBean<MdcParamFilter>  mdcParamFilter = new FilterRegistrationBean<>();
        mdcParamFilter.setFilter(new MdcParamFilter(mdcParamCollector));
        mdcParamFilter.setName("mdcParamFilter");
        mdcParamFilter.addUrlPatterns("/*");
        mdcParamFilter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return mdcParamFilter;
    }

    @Bean
    public FilterRegistrationBean<TimeIntervalFilter> timeIntervalFilter() {
        FilterRegistrationBean<TimeIntervalFilter> timeIntervalFilter = new FilterRegistrationBean<>();
        timeIntervalFilter.setFilter(new TimeIntervalFilter());
        timeIntervalFilter.setName("timeIntervalFilter");
        timeIntervalFilter.addUrlPatterns("/*");
        timeIntervalFilter.setOrder(Ordered.HIGHEST_PRECEDENCE + 8);
        return timeIntervalFilter;
    }
}
