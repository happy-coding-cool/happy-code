package cool.happycoding.code.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2021/10/19 1:32 下午
 */
@Configuration
@EnableConfigurationProperties(HappyCodeFeignProperties.class)
public class HappyCodeFeignAutoConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor(ObjectProvider<List<FeignHeaderCustomizer>> feignHeaderCustomizerObjectProvider,
                                                 HappyCodeFeignProperties happyCodeFeignProperties){
        return new FeignHeaderInterceptor(feignHeaderCustomizerObjectProvider.getIfAvailable(), happyCodeFeignProperties);
    }
}
