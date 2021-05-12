package cool.happycoding.code.log.audit.async;

import cool.happycoding.code.log.audit.HappyAuditLog;
import cool.happycoding.code.log.audit.HappyAuditRecorder;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * description
 *
 * @author lanlanhappy 2021/05/12 4:56 下午
 */
public class HappyAuditLogEventListener {

    private final HappyAuditRecorder happyAuditRecorder;

    public HappyAuditLogEventListener(HappyAuditRecorder happyAuditRecorder){
        this.happyAuditRecorder = happyAuditRecorder;
    }

    @Async
    @EventListener(HappyAuditLogEvent.class)
    public void record(HappyAuditLogEvent happyAuditLogEvent){
        HappyAuditLog happyAuditLog = (HappyAuditLog)happyAuditLogEvent.getSource();
        happyAuditRecorder.record(happyAuditLog);
    }
}
