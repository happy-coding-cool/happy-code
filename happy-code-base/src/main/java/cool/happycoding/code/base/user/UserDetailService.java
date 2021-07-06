package cool.happycoding.code.base.user;

/**
 * description
 *
 * @author lanlanhappy 2021/07/06 10:50 上午
 */
public interface UserDetailService {
    /**
     * 获取用户的详情信息
     * @param username 用户名
     * @return user
     */
    User loadUserDetail(String username);
}
