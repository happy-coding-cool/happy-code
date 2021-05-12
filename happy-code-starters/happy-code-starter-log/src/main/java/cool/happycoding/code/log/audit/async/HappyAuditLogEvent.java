package cool.happycoding.code.log.audit.async;

import org.springframework.context.ApplicationEvent;

/**
 * description
 *
 * @author lanlanhappy 2021/05/12 4:54 下午
 */
public class HappyAuditLogEvent extends ApplicationEvent {

    public HappyAuditLogEvent(Object source) {
        super(source);
    }
}
