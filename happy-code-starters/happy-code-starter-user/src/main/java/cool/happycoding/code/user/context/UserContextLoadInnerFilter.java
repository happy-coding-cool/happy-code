package cool.happycoding.code.user.context;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.user.User;
import cool.happycoding.code.base.user.UserContextService;
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

    private final UserContextService userContextService;
    private final UserContextProperties userContextProperties;

    public UserContextLoadInnerFilter(UserContextService userContextService, UserContextProperties userContextProperties) {
        this.userContextService = userContextService;
        this.userContextProperties = userContextProperties;
    }

    @Override
    public void filter(HttpServletRequest request) {
        String userId = request.getHeader(userContextProperties.getUserIdField());
        log.info("request header user-id:{}", userId);
        User user = userContextService.loadUserDetail(userId);
        if (ObjectUtil.isNull(user)) {
            user = DefaultUser.defaultUser(userContextProperties.getDefaultUserId(), userContextProperties.getDefaultUserName());
        }
        UserContextHolder.setUser(user);
    }

    @Override
    public int getOrder() {
        return userContextProperties.getFilterOrder();
    }

}