package cool.happycoding.code.user.filter;

import com.google.common.collect.Lists;
import cool.happycoding.code.user.UserInnerFilter;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *     加载 user context
 * </p>
 *
 * @author lanlanhappy 2020/12/03 9:26 下午
 */
public class UserContextLoadFilter implements Filter {

    private final List<UserInnerFilter> userInnerFilters;
    private final List<String> skipUrls = Lists.newArrayList();
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    public UserContextLoadFilter(List<UserInnerFilter> userInnerFilters){

        this.userInnerFilters = userInnerFilters;
        skipUrls.add("/**/happy/auth/**");
        skipUrls.add("/**/happy/captcha/**");
        skipUrls.add("/**/actuator/health/**");
        skipUrls.add("/**/doc.html");
        skipUrls.add("/**/webjars/**");
        skipUrls.add("/**/v2/api-docs/**");
        skipUrls.add("/**/swagger-resources");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest)request).getRequestURI();
        if (!match(url)){
            try {
                userInnerFilters.forEach(userInnerFilter -> userInnerFilter.filter((HttpServletRequest)request));
                filterChain.doFilter(request, response);
            } finally {
                userInnerFilters.forEach(UserInnerFilter::post);
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }

    private boolean match(String url){
        return skipUrls.stream().anyMatch(pattern->antPathMatcher.match(pattern, url));
    }
}
