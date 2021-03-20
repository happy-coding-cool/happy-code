package cool.happycoding.code.base.user;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:20 下午
 */
public interface Authority extends Serializable {
    /**
     * 获取授权
     * @return string
     */
    String getAuthority();
}
