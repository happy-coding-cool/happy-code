package cool.happycoding.code.mybatis;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import cool.happycoding.code.user.context.UserContextHolder;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

/**
 * description
 *
 * @author lanlanhappy 2021/02/23 2:20 下午
 */
public class HappyTenantLineHandler implements TenantLineHandler {

    private final HappyMybatisProperties happyMybatisProperties;

    public HappyTenantLineHandler(HappyMybatisProperties happyMybatisProperties) {
        this.happyMybatisProperties = happyMybatisProperties;
    }

    @Override
    public Expression getTenantId() {
        return new StringValue(UserContextHolder.getUser().tenantId());
    }

    @Override
    public String getTenantIdColumn() {
        return StrUtil.blankToDefault(happyMybatisProperties.getTenantIdColumn(), "tenant_id");
    }

    @Override
    public boolean ignoreTable(String tableName) {
        if (CollUtil.isNotEmpty(happyMybatisProperties.getIgnoreTables())) {
            return happyMybatisProperties.getIgnoreTables().contains(tableName);
        }
        return false;
    }
}
