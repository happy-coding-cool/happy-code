package cool.happycoding.code.web;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:46 下午
 */
@Data
@ConfigurationProperties(prefix = HappyWebProperties.HAPPY_WEB_PREFIX)
public class HappyWebProperties {

    public static final String HAPPY_WEB_PREFIX = "happy.code.web";

    public final static String DEFAULT_MEDIA_TYPE = MediaType.APPLICATION_JSON_VALUE;

    private Serializer serializer = new Serializer();
    private Deserializer deserializer = new Deserializer();

    @Data
    public static class Serializer{

        public static final String SERIALIZER_PREFIX = HappyWebProperties.HAPPY_WEB_PREFIX + ".serializer";
        /**
         * 是否启用日期类型字段统一序列化
         */
        private boolean enableDate = true;
        /**
         * 是否启用数字型字段统一序列化
         */
        private boolean enableBigDecimalAsPlain = true;
        /**
         * 是否启用Long类型字段统一序列化
         */
        private boolean enableLongAsPlain = true;
        /**
         * 默认日期格式
         */
        private String dateFormat = Constants.DATE_TIME_FORMAT;
    }

    @Data
    public static class Deserializer{
        public static final String DESERIALIZER_PREFIX = HappyWebProperties.HAPPY_WEB_PREFIX + ".deserializer";
        /**
         * 是否启用日期类型字段统一反序列化
         */
        private boolean enableDate = true;
    }

}
