package cool.happycoding.code.log.audit;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/04/10 5:13 下午
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HappyAudit {
    /**
     * 操作信息
     */
    String operation();
}
