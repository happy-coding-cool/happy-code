package cool.happycoding.code.mybatis;

import static cn.hutool.core.util.StrUtil.blankToDefault;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 11:23 上午
 */
public class DefaultAutoFieldFillHandler implements AutoFieldFillHandler{
    @Override
    public String createdBy() {
        return blankToDefault(currentUser().getUserName(), DEFAULT_USERNAME);
    }

    @Override
    public String createdById() {
        return blankToDefault(currentUser().getUserId(), DEFAULT_USER_ID);
    }

    @Override
    public String updatedBy() {
        return blankToDefault(currentUser().getUserName(), DEFAULT_USERNAME);
    }

    @Override
    public String updatedById() {
        return blankToDefault(currentUser().getUserId(), DEFAULT_USER_ID);
    }

    @Override
    public String tenantId() {
        return blankToDefault(currentUser().tenantId(), DEFAULT_TENANT_ID);
    }
}

