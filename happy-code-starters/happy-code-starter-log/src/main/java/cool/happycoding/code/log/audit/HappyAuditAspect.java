package cool.happycoding.code.log.audit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * description
 *
 * @author lanlanhappy 2021/04/10 5:16 下午
 */
@Slf4j
@Aspect
public class HappyAuditAspect {

    private final HappyAuditRecorder happyAuditRecorder;

    public HappyAuditAspect(HappyAuditRecorder happyAuditRecorder){
        this.happyAuditRecorder = happyAuditRecorder;
    }

    /**
     *  添加审计功能
     */
    @Before("@within(happyAudit) || @annotation(happyAudit)")
    public void audit(JoinPoint joinPoint, HappyAudit happyAudit) {
        if (happyAudit == null) {
            // 获取类上的注解
            happyAudit = joinPoint.getTarget().getClass().getDeclaredAnnotation(HappyAudit.class);
        }
        // TODO 组织审计信息
//        HappyAuditLog happyAuditLog = buildAudit(happyAudit, joinPoint);
        HappyAuditLog happyAuditLog = new HappyAuditLog();
        happyAuditRecorder.record(happyAuditLog);
    }
}
