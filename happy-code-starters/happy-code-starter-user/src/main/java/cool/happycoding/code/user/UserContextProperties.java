package cool.happycoding.code.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static cool.happycoding.code.base.common.Constants.*;

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
    private String defaultUserId = DEFAULT_USER_ID;
    /**
     * 默认用户名
     */
    private String defaultUserName = DEFAULT_USER_NAME;

    /**
     * 用户Id字段名
     */
    private String userIdField = HEADER_USER_ID;

    /**
     * filter order 优先级
     */
    private int filterOrder = 1;


}
