package cool.happycoding.code.base.user;

/**
 * description
 * <p>2021/07/06 该接口在 1.0.3 版本之后逐渐废弃,请参考：UserDetailService</p>
 * @since  UserDetailService
 * @author lanlanhappy 2020/12/03 9:21 下午
 */
public interface UserContextService {

    /**
     * 获取用户的详情信息
     * @param userId
     * @return user
     */
    User loadUserDetailById(String userId);
}
