package cool.happycoding.code.log.audit;

/**
 * description
 *
 * @author lanlanhappy 2021/04/20 9:29 下午
 */
public interface HappyAuditRecorder {

    /**
     * 记录审计日志信息
     * @param happyAuditLog
     */
    void record(HappyAuditLog happyAuditLog);

}
