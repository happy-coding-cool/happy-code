package cool.happycoding.code.user;

import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:47 下午
 */
public interface UserInnerFilter extends Ordered {

    /**
     * 提供 UserContextLoadFilter#filter 执行扩展
     * @param request
     */
    void filter(HttpServletRequest request);


}

