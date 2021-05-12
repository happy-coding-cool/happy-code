package cool.happycoding.code.log.audit.async;

import cool.happycoding.code.log.audit.HappyAuditLog;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * description
 *
 * @author lanlanhappy 2021/05/12 5:05 下午
 */
public class SpringHappyAuditLogEventPublisher implements HappyAuditLogEventPublisher, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void publish(HappyAuditLog happyAuditLog) {
        applicationContext.publishEvent(new HappyAuditLogEvent(happyAuditLog));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
