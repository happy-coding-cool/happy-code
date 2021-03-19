package cool.happycoding.code.cache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * <p>
 *     在定义组合注解时需要将被组合注解的属性，全部代理掉避免丢失原注解属性导致的注解解析问题
 *     如：EnableMethodCache注解里有：basePackages,proxyTargetClass,mode,order 四个属性
 *     就需要在 EnableHappyCache 注解定义里全部代理掉
 * </p>
 *
 * @author lanlanhappy 2021/02/21 11:34 上午
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableMethodCache(basePackages = {})
@EnableCreateCacheAnnotation
public @interface EnableHappyCache {

    @AliasFor(
            annotation = EnableMethodCache.class,
            attribute = "basePackages"
    )
    String[] basePackages();

    @AliasFor(
            annotation = EnableMethodCache.class,
            attribute = "proxyTargetClass"
    )
    boolean proxyTargetClass() default false;

    @AliasFor(
            annotation = EnableMethodCache.class,
            attribute = "mode"
    )
    AdviceMode mode() default AdviceMode.PROXY;

    @AliasFor(
            annotation = EnableMethodCache.class,
            attribute = "order"
    )
    int order() default Ordered.LOWEST_PRECEDENCE;


}
