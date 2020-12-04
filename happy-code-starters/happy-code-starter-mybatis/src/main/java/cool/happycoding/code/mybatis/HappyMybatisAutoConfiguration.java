package cool.happycoding.code.mybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

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
    public PaginationInnerInterceptor paginationInnerInterceptor(HappyMybatisProperties happyMybatisProperties){
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setMaxLimit(happyMybatisProperties.getLimit());
        paginationInnerInterceptor.setOverflow(happyMybatisProperties.isOverflow());
        return paginationInnerInterceptor;
    }

    @Bean
    @ConditionalOnProperty(name = HappyMybatisProperties.HAPPY_MYBATIS_PREFIX+".enable-block-attack", havingValue = "true")
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor(){
        return new BlockAttackInnerInterceptor();
    }


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(ObjectProvider<List<InnerInterceptor>> innerInterceptorProvider){
        List<InnerInterceptor> innerInterceptors = innerInterceptorProvider.getIfAvailable();
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.setInterceptors(innerInterceptors);
        return mybatisPlusInterceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer(){
        return properties -> properties.getGlobalConfig().setBanner(Boolean.FALSE);
    }

}
