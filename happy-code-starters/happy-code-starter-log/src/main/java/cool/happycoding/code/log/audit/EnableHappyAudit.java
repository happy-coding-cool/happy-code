package cool.happycoding.code.log.audit;

/**
 * description
 *
 * @author lanlanhappy 2021/04/20 9:36 下午
 */

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableAsync
@Import({HappyAuditConfiguration.class})
public @interface EnableHappyAudit {
}
