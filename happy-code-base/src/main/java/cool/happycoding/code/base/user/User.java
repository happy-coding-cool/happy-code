package cool.happycoding.code.base.user;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collection;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:20 下午
 */
public interface User extends Serializable {

    /**
     * 获取userId
     * @return
     */
    String getUserId();

    /**
     * 获取userName
     * @return
     */
    String getUserName();

    /**
     * 获取密码
     * @return
     */
    String getPassword();

    /**
     * 获取权限
     * @return
     */
    default Collection<? extends Authority> getAuthorities(){ return Lists.newArrayList(); }

    /**
     * 用户所在的租户
     * @return
     */
    default String tenantId(){
        return "null";
    }
}

