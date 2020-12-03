package cool.happycoding.code.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:46 下午
 */
@Data
@ConfigurationProperties(prefix = UserContextProperties.HAPPY_USER_CONTEXT_PREFIX)
public class UserContextProperties {

    public static final String HAPPY_USER_CONTEXT_PREFIX = "happy.code.user";

    /**
     * 默认用户Id
     */
    private String defaultUserId = "-1";
    /**
     * 默认用户名
     */
    private String defaultUserName = "system";

    /**
     * 用户Id字段名
     */
    private String userIdField = "user-id";

    /**
     * filter order 优先级
     */
    private int filterOrder = 1;


}
