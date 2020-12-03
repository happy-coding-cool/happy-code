package cool.happycoding.code.web.sample.filter;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static cool.happycoding.code.base.util.HappyCodeUtil.check;
import static cool.happycoding.code.web.sample.WebStatus.PARAM_ILLEGAL;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 9:06 下午
 */
@Component
@WebFilter("/exception")
public class WebSampleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        check(StrUtil.equalsAnyIgnoreCase(request.getParameter("id"), "999"), PARAM_ILLEGAL);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
