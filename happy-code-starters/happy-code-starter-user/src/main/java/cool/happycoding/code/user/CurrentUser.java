package cool.happycoding.code.user;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 9:53 下午
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
