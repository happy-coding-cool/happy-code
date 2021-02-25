package cool.happycoding.code.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import cool.happycoding.code.web.fastjson.CustomerFastJsonConfig;
import cool.happycoding.code.web.exception.GlobalExceptionHandler;
import cool.happycoding.code.web.exception.HappyErrorController;
import cool.happycoding.code.web.filter.TimeIntervalFilter;
import cool.happycoding.code.web.jackson2.CustomerJackson2Config;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:46 下午
 */
@Configuration
@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
@EnableConfigurationProperties({HappyWebProperties.class})
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
public class HappyWebAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Bean
    @SuppressWarnings("all")
    @ConditionalOnMissingBean
    public HappyErrorController happyErrorController(ErrorAttributes errorAttributes){
        return new HappyErrorController(errorAttributes);
    }

    @Bean
    @ConditionalOnProperty(name = HappyWebProperties.HAPPY_WEB_PREFIX + ".converter-type", havingValue = "jackson2")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(HappyWebProperties happyWebProperties){
        return new CustomerJackson2Config(happyWebProperties);
    }

    @Bean
    @ConditionalOnClass({JSON.class, HttpMessageConverter.class})
    @ConditionalOnProperty(name = HappyWebProperties.HAPPY_WEB_PREFIX + ".converter-type", havingValue = "fastjson", matchIfMissing = true)
    public HttpMessageConverters fastJsonHttpMessageConverter(HappyWebProperties happyWebProperties){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = MediaType.parseMediaTypes(HappyWebProperties.DEFAULT_MEDIA_TYPE);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastConverter.setFastJsonConfig(new CustomerFastJsonConfig(happyWebProperties).fastJsonConfig());
        return new HttpMessageConverters(fastConverter);
    }

    @Bean
    public FilterRegistrationBean<TimeIntervalFilter> timeIntervalFilter() {
        FilterRegistrationBean<TimeIntervalFilter> timeIntervalFilter = new FilterRegistrationBean<>();
        timeIntervalFilter.setFilter(new TimeIntervalFilter());
        timeIntervalFilter.setName("timeIntervalFilter");
        timeIntervalFilter.addUrlPatterns("/*");
        timeIntervalFilter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return timeIntervalFilter;
    }
}
