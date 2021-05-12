package cool.happycoding.code.log.audit.async;

import cool.happycoding.code.log.audit.HappyAuditLog;

/**
 * description
 *
 * @author lanlanhappy 2021/05/12 5:03 下午
 */
public interface HappyAuditLogEventPublisher {

    /**
     * 发布日志事件
     * @param happyAuditLog
     */
    void publish(HappyAuditLog happyAuditLog);
}
