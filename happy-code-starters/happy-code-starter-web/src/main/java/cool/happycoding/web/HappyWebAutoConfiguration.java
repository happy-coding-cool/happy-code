package cool.happycoding.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import cool.happycoding.web.exception.GlobalExceptionHandler;
import cool.happycoding.web.fastjson.CustomerFastJsonConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableConfigurationProperties({HappyWebProperties.class})
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
public class HappyWebAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Bean
    @ConditionalOnClass({JSON.class, HttpMessageConverter.class})
    public HttpMessageConverters fastJsonHttpMessageConverter(HappyWebProperties happyWebProperties){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = MediaType.parseMediaTypes(HappyWebProperties.DEFAULT_MEDIA_TYPE);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastConverter.setFastJsonConfig(new CustomerFastJsonConfig(happyWebProperties).fastJsonConfig());
        return new HttpMessageConverters(fastConverter);
    }
}
