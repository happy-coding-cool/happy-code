package cool.happycoding.code.validator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 9:33 下午
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = ValidatorProperties.HAPPY_BOOT_VALIDATE_PREFIX)
public class ValidatorProperties {

    public static final String HAPPY_BOOT_VALIDATE_PREFIX = "happy.code.validator";
    /**
     * 是否采用快速失败模式，默认 false
     */
    private Boolean failFast = Boolean.FALSE;


}
