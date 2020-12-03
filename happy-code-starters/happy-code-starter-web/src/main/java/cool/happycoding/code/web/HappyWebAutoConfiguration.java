package cool.happycoding.code.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import cool.happycoding.code.web.fastjson.CustomerFastJsonConfig;
import cool.happycoding.code.web.exception.GlobalExceptionHandler;
import cool.happycoding.code.web.exception.HappyErrorController;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
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
    @ConditionalOnMissingBean
    public HappyErrorController happyErrorController(ErrorAttributes errorAttributes){
        return new HappyErrorController(errorAttributes);
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
