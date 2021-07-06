package cool.happycoding.code.user.context;

import cn.hutool.core.util.ObjectUtil;
import cool.happycoding.code.base.user.User;
import cool.happycoding.code.base.user.UserDetailService;
import cool.happycoding.code.user.DefaultUser;
import cool.happycoding.code.user.UserContextProperties;
import cool.happycoding.code.user.UserInnerFilter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:48 下午
 */
@Slf4j
public class UserContextLoadInnerFilter implements UserInnerFilter {

    private final UserDetailService userContextService;
    private final UserContextProperties userContextProperties;

    public UserContextLoadInnerFilter(UserDetailService userContextService, UserContextProperties userContextProperties) {
        this.userContextService = userContextService;
        this.userContextProperties = userContextProperties;
    }

    @Override
    public void filter(HttpServletRequest request) {
        String userId = request.getHeader(userContextProperties.getUserIdField());
        log.warn("request header user-id:{}", userId);
        User user = userContextService.loadUserDetail(userId);
        if (ObjectUtil.isNull(user)) {
            user = DefaultUser.defaultUser(userContextProperties.getDefaultUserId(), userContextProperties.getDefaultUserName());
        }
        UserContextHolder.setUser(user);
    }

    @Override
    public void post() {
        UserContextHolder.clear();
    }

    @Override
    public int getOrder() {
        return userContextProperties.getFilterOrder();
    }

}