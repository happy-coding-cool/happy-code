package cool.happycoding.code.log;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 9:34 上午
 */
@Data
@ConfigurationProperties(prefix = HappyLogProperties.HAPPY_LOG_PREFIX)
public class HappyLogProperties {

    public static final String HAPPY_LOG_PREFIX = "happy.code.log";

    /**
     * 是否启用mdc特性，默认：true 启用
     */
    private boolean enableMdc = true;

    /**
     * 是否打印执行间隔时间，默认：true 打印
     */
    private boolean enableExeTime = true;

    /**
     * 是否打印，请求header，默认：false 不打印
     */
    private boolean enablePrintHeader = false;
    /**
     * 是否打印，请求参数，默认：false 不打印
     */
    private boolean enablePrintRequest = false;
    /**
     * 是否打印，返回值，默认：false 不打印
     */
    private boolean enablePrintResponse = false;

    /**
     * 忽略打印的url请求，数组
     */
    private List<String> excludes = Lists.newArrayList();

}
