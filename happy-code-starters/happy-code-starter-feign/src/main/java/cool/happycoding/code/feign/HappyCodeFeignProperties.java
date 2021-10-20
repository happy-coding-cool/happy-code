package cool.happycoding.code.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;

import static cool.happycoding.code.feign.HappyCodeFeignProperties.HAPPY_FEIGN_PREFIX;

/**
 * description
 *
 * @author lanlanhappy 2021/10/19 1:34 下午
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = HAPPY_FEIGN_PREFIX)
public class HappyCodeFeignProperties {

    public static final String HAPPY_FEIGN_PREFIX = "happy.code.feign";


    /**
     * 需要传递的header的key
     */
    private List<String> headers;
}
