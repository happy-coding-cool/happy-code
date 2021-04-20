package cool.happycoding.code.log.audit;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description
 *
 * @author lanlanhappy 2021/04/10 5:14 下午
 */
@Data
public class HappyAuditLog implements Serializable {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 操作时间
     */
    private LocalDateTime timestamp;
    /**
     * 应用名
     */
    private String applicationName;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 操作信息
     */
    private String operation;
}
