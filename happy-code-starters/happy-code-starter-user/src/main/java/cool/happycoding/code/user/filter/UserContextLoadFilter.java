package cool.happycoding.code.user.filter;

import cool.happycoding.code.user.UserInnerFilter;
import cool.happycoding.code.user.context.UserContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 *     加载 user context
 * </p>
 *
 * @author lanlanhappy 2020/12/03 9:26 下午
 */
public class UserContextLoadFilter implements Filter {

    private final UserInnerFilter userInnerFilter;

    public UserContextLoadFilter(UserInnerFilter userInnerFilter){
        this.userInnerFilter = userInnerFilter;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            userInnerFilter.filter((HttpServletRequest)request);
            filterChain.doFilter(request, response);
        } finally {
            UserContextHolder.clear();
        }
    }
}
