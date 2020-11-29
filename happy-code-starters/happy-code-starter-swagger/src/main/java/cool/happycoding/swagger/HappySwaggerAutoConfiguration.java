package cool.happycoding.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:52 下午
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@RequiredArgsConstructor
@Import(BeanValidatorPluginsConfiguration.class)
@EnableConfigurationProperties(HappySwaggerProperties.class)
@ConditionalOnProperty(name = HappySwaggerProperties.HAPPY_SWAGGER_PREFIX+".enable", matchIfMissing = true)
public class HappySwaggerAutoConfiguration {

    private final HappySwaggerProperties happySwaggerProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(happySwaggerProperties.getGroup())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(happySwaggerProperties.getBasePackage()))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(happySwaggerProperties.getTitle())
                .description(happySwaggerProperties.getDescription())
                .termsOfServiceUrl(happySwaggerProperties.getServiceUrl())
                .version(happySwaggerProperties.getVersion())
                .contact(new Contact(happySwaggerProperties.getContact().getName(),
                        happySwaggerProperties.getContact().getUrl(),
                        happySwaggerProperties.getContact().getEmail()))
                .build();
    }


}
