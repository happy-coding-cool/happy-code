package cool.happycoding.code.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:53 下午
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = HappySwaggerProperties.HAPPY_SWAGGER_PREFIX)
public class HappySwaggerProperties {

    public static final String HAPPY_SWAGGER_PREFIX = "happy.code.swagger";

    /**
     * 是否启用swagger
     */
    private Boolean enable = Boolean.TRUE;

    /**
     * 分组名称
     */
    private String group;

    /**
     * swagger文档扫描包路径
     */
    private String basePackage;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档描述
     */
    private String description;

    /**
     * 文档版本
     */
    private String version;

    /**
     * 文档地址
     */
    private String serviceUrl;


    /**
     * 项目联系方式
     */
    private Contact contact = new Contact();

    @Data
    public static class Contact {

        public static final String prefix = HappySwaggerProperties.HAPPY_SWAGGER_PREFIX + ".contact";
        /**
         * 项目联系人名字
         */
        private  String name;
        /**
         * 项目URL
         */
        private  String url;
        /**
         * 项目联系人邮箱
         */
        private  String email;

    }


}
