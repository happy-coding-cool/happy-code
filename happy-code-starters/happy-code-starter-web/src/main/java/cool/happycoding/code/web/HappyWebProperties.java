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

    /**
     * 序列化配置
     */
    private Serializer serializer = new Serializer();

    /**
     * 反序列化配置
     */
    private Deserializer deserializer = new Deserializer();

    /**
     * 默认线程池配置
     */
    private Pool pool = new Pool();

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

    /**
     * 类型:fastjson、jackson2
     */
    private ConverterType converterType = ConverterType.fastjson;

    public enum ConverterType{

        /**
         * fast-json
         */
        fastjson,

        /**
         * jackson2
         */
        jackson2;
    }

    @Data
    public static class Pool {

        /**
         * 核心线程数
         */
        int corePoolSize = 10;
        /**
         * 最大线程数
         */
        int maxPoolSize = 32;
        /**
         * 设置线程执行超时后是否回收线程，默认：true
         */
        boolean allowCoreThreadTimeOut = true;
        /**
         * 设置线程存活时间，即当池中线程多于初始大小时，多出的线程保留的时长，单位:毫秒，默认：60000（60秒）
         */
        long keepAliveTime = 60000;
        /**
         * 阻塞队列容量 大小，默认：512
         */
        int queueCapacity = 512;
    }
}
