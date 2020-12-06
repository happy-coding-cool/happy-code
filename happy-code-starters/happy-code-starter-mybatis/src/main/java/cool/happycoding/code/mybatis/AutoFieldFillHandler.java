package cool.happycoding.code.mybatis;

import cool.happycoding.code.base.user.User;
import cool.happycoding.code.user.DefaultUser;
import cool.happycoding.code.user.context.UserContextHolder;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 11:23 上午
 */
public interface AutoFieldFillHandler {

    String DEFAULT_USERNAME    = "system";
    String DEFAULT_USER_ID     = "-1";
    String DEFAULT_TENANT_ID   = "null";
    String CREATED_BY      = "createdBy";
    String CREATED_BY_ID   = "createdById";
    String CREATED_TIME    = "createdTime";
    String UPDATED_BY      = "updatedBy";
    String UPDATED_BY_ID   = "updatedById";
    String UPDATED_TIME    = "updatedTime";

    /**
     * 记录创建人：名称
     * @return
     */
    String createdBy();


    /**
     * 记录创建人Id
     * @return
     */
    String createdById();

    /**
     * 记录修改人：名称
     * @return
     */
    String updatedBy();

    /**
     * 记录修改人Id
     * @return
     */
    String updatedById();

    /**
     * 获取的租户
     * @return
     */
    String tenantId();

    /**
     * 获取当前上下文用户
     * @return
     */
    default User currentUser(){
        User user = UserContextHolder.getUser();
        return user == null ? new DefaultUser() : user;
    }
}
