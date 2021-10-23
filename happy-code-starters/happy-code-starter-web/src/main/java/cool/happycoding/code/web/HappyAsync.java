package cool.happycoding.code.web;

import org.springframework.scheduling.annotation.Async;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 11:08 上午
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Async(value = "happyThreadPoolExecutor")
public @interface HappyAsync {
}
