package cool.happycoding.code.log.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 10:19 上午
 */
public class HappyServletRequestWrapper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public HappyServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
}
