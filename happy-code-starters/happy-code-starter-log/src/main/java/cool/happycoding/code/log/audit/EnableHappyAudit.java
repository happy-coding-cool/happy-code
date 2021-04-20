package cool.happycoding.code.log.audit;

/**
 * description
 *
 * @author lanlanhappy 2021/04/20 9:36 下午
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({HappyAuditConfiguration.class})
public @interface EnableHappyAudit {
}
