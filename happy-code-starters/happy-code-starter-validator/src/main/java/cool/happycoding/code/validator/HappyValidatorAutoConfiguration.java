package cool.happycoding.code.validator;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Maps;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Map;

import static cn.hutool.core.util.ObjectUtil.isNotNull;

/**
 * <p>
 *     入参校验
 * </p>
 *
 * @author lanlanhappy 2020/12/01 9:33 下午
 */
@Configuration
@AutoConfigureBefore(ValidationAutoConfiguration.class)
@EnableConfigurationProperties({ValidatorProperties.class})
public class HappyValidatorAutoConfiguration {

    private final ValidatorProperties validatorProperties;

    public HappyValidatorAutoConfiguration(ValidatorProperties validatorProperties) {
        this.validatorProperties = validatorProperties;
    }

    @Bean
    @Primary
    public LocalValidatorFactoryBean defaultValidator(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        Map<String, String> validationProperties = Maps.newHashMap();
        if (isNotNull(validatorProperties.getFailFast())){
            validationProperties.put("hibernate.validator.fail_fast", validatorProperties.getFailFast().toString());
        }
        if (CollUtil.isNotEmpty(validationProperties)) {
            localValidatorFactoryBean.setValidationPropertyMap(validationProperties);
        }

        return localValidatorFactoryBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public ValidatorEnhance validatorEnhance(){
        return new ValidatorEnhance(defaultValidator());
    }

}
