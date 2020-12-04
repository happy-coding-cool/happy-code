package cool.happycoding.code.mybatis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 10:03 下午
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = HappyMybatisProperties.HAPPY_MYBATIS_PREFIX)
public class HappyMybatisProperties {

    public static final String HAPPY_MYBATIS_PREFIX = "happy.code.mybatis";

    /**
     * 单页限制的条数，默认：-1（不受限制）
     */
    protected long limit = -1;

    /**
     * 溢出总页数后是否进行处理
     */
    protected boolean overflow = Boolean.FALSE;

    /**
     * 是否启用多租户
     */
    private boolean enableTenant = Boolean.FALSE;

    /**
     * 是否启用update或delete全表操作阻断，默认：启用
     */
    private boolean enableBlockAttack = Boolean.TRUE;

    /**
     *  启用多租户时，指定表的租户字段名，默认：tenant_id
     */
    private String tenantIdColumn = "tenant_id";

    /**
     * 启用多租户时，指定哪些表不需要租户隔离
     */
    private String[] ignoreTables;


}
