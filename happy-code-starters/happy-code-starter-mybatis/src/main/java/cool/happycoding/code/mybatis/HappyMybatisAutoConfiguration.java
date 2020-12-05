package cool.happycoding.code.mybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

import static cool.happycoding.code.mybatis.InnerInterceptorHolder.blockAttackInnerInterceptor;
import static cool.happycoding.code.mybatis.InnerInterceptorHolder.paginationInnerInterceptor;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 10:02 下午
 */
@Configuration
@PropertySource({"classpath:happy-mybatis.properties"})
@EnableConfigurationProperties({HappyMybatisProperties.class})
public class HappyMybatisAutoConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(HappyMybatisProperties happyMybatisProperties){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        List<InnerInterceptor> interceptors = Lists.newArrayList();
        if (happyMybatisProperties.isEnableBlockAttack()) {
            interceptors.add(blockAttackInnerInterceptor());
        }
        // 分页插件要放到所有interceptor之后
        interceptors.add(paginationInnerInterceptor(happyMybatisProperties));
        mybatisPlusInterceptor.setInterceptors(interceptors);
        return mybatisPlusInterceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer(HappyMybatisProperties happyMybatisProperties){
        return properties -> {
            properties.getGlobalConfig().setBanner(Boolean.FALSE);
            properties.getGlobalConfig().getDbConfig().setIdType(happyMybatisProperties.getIdType());
        };
    }

}
