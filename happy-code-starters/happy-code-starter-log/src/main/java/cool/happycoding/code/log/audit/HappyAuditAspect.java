package cool.happycoding.code.log.audit;

import cool.happycoding.code.base.user.User;
import cool.happycoding.code.log.audit.async.HappyAuditLogEvent;
import cool.happycoding.code.log.audit.async.HappyAuditLogEventPublisher;
import cool.happycoding.code.user.context.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.time.LocalDateTime;

/**
 * description
 *
 * @author lanlanhappy 2021/04/10 5:16 下午
 */
@Slf4j
@Aspect
public class HappyAuditAspect  {

    @Value("${spring.application.name}")
    private String applicationName;

    private final HappyAuditLogEventPublisher happyAuditLogEventPublisher;

    public HappyAuditAspect(HappyAuditLogEventPublisher happyAuditLogEventPublisher){
        this.happyAuditLogEventPublisher = happyAuditLogEventPublisher;
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
        // 构造审计信息
        HappyAuditLog happyAuditLog = buildAudit(happyAudit, joinPoint);
        happyAuditLogEventPublisher.publish(happyAuditLog);
    }

    private HappyAuditLog buildAudit(HappyAudit happyAudit, JoinPoint joinPoint) {
        HappyAuditLog happyAuditLog = new HappyAuditLog();
        User user = UserContextHolder.getUser();
        happyAuditLog.setUserId(user.getUserId());
        happyAuditLog.setUserName(user.getUserName());
        happyAuditLog.setTimestamp(LocalDateTime.now());
        happyAuditLog.setApplicationName(applicationName);
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        happyAuditLog.setMethodName(methodSignature.getName());
        happyAuditLog.setClassName(methodSignature.getDeclaringTypeName());
        happyAuditLog.setOperation(happyAudit.operation());
        return happyAuditLog;
    }

}
