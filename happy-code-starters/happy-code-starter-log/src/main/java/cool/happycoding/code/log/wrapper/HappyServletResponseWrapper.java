package cool.happycoding.code.log.wrapper;

import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 10:19 上午
 */
public class HappyServletResponseWrapper extends ContentCachingResponseWrapper {

    /**
     * Create a new ContentCachingResponseWrapper for the given servlet response.
     *
     * @param response the original servlet response
     */
    public HappyServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public String response(){
        byte[] buf = getContentAsByteArray();
        if (buf.length > 0) {
            try {
                return new String(buf, getCharacterEncoding());
            }catch (UnsupportedEncodingException ex) {
                return "[unknown]";
            }
        }
        return "null";
    }
}
