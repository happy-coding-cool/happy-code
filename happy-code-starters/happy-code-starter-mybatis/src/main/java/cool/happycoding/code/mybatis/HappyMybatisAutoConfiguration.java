package cool.happycoding.code.mybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 10:02 下午
 */
@Configuration
@RequiredArgsConstructor
@PropertySource({"classpath:happy-mybatis.properties"})
@EnableConfigurationProperties({HappyMybatisProperties.class})
public class HappyMybatisAutoConfiguration {

    private final HappyMybatisProperties happyMybatisProperties;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(ObjectProvider<List<InnerInterceptor>> interceptorProvider){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        List<InnerInterceptor> interceptors = interceptorProvider.getIfAvailable();
        if (interceptors != null) {
            AnnotationAwareOrderComparator.sort(interceptors);
        }
        // 分页插件要放到所有interceptor之后
        mybatisPlusInterceptor.setInterceptors(interceptors);
        return mybatisPlusInterceptor;
    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    @Order(999)
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(happyMybatisProperties.isOverflow());
        // 设置最大单页限制数量
        paginationInterceptor.setMaxLimit(happyMybatisProperties.getLimit());
        return paginationInterceptor;
    }

    /**
     * 阻塞插件，用于sql安全执行
     * @return
     */
    @Bean
    @Order(1)
    @ConditionalOnProperty(name = HappyMybatisProperties.HAPPY_MYBATIS_PREFIX + ".enable-block-attack", havingValue = "true")
    public  BlockAttackInnerInterceptor blockAttackInnerInterceptor(){
        return new BlockAttackInnerInterceptor();
    }

    @Bean
    @Order(10)
    @ConditionalOnProperty(name = HappyMybatisProperties.HAPPY_MYBATIS_PREFIX + ".enable-version", havingValue = "true")
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        //乐观锁拦截器
        return new OptimisticLockerInnerInterceptor();
    }

    @Bean
    @Order(22)
    @ConditionalOnProperty(name = HappyMybatisProperties.HAPPY_MYBATIS_PREFIX + ".enable-tenant", havingValue = "true")
    public TenantLineInnerInterceptor tenantLineInnerInterceptor(){
        TenantLineInnerInterceptor tenantLineInnerInterceptor = new TenantLineInnerInterceptor();
        tenantLineInnerInterceptor.setTenantLineHandler(new HappyTenantLineHandler(happyMybatisProperties));
        return tenantLineInnerInterceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer(HappyMybatisProperties happyMybatisProperties){
        return properties -> {
            properties.getGlobalConfig().setBanner(Boolean.FALSE);
            properties.getGlobalConfig().getDbConfig().setIdType(happyMybatisProperties.getIdType());
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public AutoFieldFillHandler autoFieldFillHandler(){
        return new DefaultAutoFieldFillHandler();
    }

    @Bean
    public MetaObjectHandler metaObjectHandler(AutoFieldFillHandler autoFieldFillHandler){
        return new HappyMybatisMetaObjectHandler(autoFieldFillHandler);
    }

}
