package cool.happycoding.code.mybatis;

import static cool.happycoding.code.base.util.HappyCodeUtil.ifBlankDefault;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 11:23 上午
 */
public class DefaultAutoFieldFillHandler implements AutoFieldFillHandler{
    @Override
    public String createdBy() {
        return ifBlankDefault(currentUser().getUserName(), DEFAULT_USERNAME);
    }

    @Override
    public String createdById() {
        return ifBlankDefault(currentUser().getUserId(), DEFAULT_USER_ID);
    }

    @Override
    public String updatedBy() {
        return ifBlankDefault(currentUser().getUserName(), DEFAULT_USERNAME);
    }

    @Override
    public String updatedById() {
        return ifBlankDefault(currentUser().getUserId(), DEFAULT_USER_ID);
    }

    @Override
    public String tenantId() {
        return ifBlankDefault(currentUser().tenantId(), DEFAULT_TENANT_ID);
    }
}

