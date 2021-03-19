package cool.happycoding.code.cache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * description
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
