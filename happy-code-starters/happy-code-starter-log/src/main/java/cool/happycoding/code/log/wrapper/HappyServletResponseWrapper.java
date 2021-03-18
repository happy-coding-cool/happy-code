package cool.happycoding.code.log.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 10:19 上午
 */
public class HappyServletResponseWrapper extends HttpServletResponseWrapper {
    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response The response to be wrapped
     * @throws IllegalArgumentException if the response is null
     */
    public HappyServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }
}
