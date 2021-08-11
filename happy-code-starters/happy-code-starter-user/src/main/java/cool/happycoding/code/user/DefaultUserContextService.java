package cool.happycoding.code.user;

import cool.happycoding.code.base.user.User;
import cool.happycoding.code.base.user.UserContextService;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:52 下午
 */
public class DefaultUserContextService implements UserContextService {

    private final UserContextProperties userContextProperties;

    public DefaultUserContextService(UserContextProperties userContextProperties){
        this.userContextProperties = userContextProperties;
    }

    @Override
    public User loadUserDetailById(String userId) {
        return DefaultUser.defaultUser(userContextProperties.getDefaultUserId(),
                userContextProperties.getDefaultUserName());
    }
}
