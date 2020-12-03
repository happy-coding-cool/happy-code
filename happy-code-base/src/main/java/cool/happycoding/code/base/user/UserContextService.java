package cool.happycoding.code.base.user;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:21 下午
 */
public interface UserContextService {
    /**
     * 获取用户的详情信息
     * @param username
     * @return
     */
    User loadUserDetail(String username);
}
