package cool.happycoding.code.log.wrapper;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 10:19 上午
 */
public class HappyServletRequestWrapper extends ContentCachingRequestWrapper {

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    @SneakyThrows
    public HappyServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 获取 header 参数
     * @return
     */
    public String headers(){
        HttpHeaders headers = new HttpHeaders();
        HttpServletRequest request = (HttpServletRequest)this.getRequest();
        for (Iterator<String> iterator = IterUtil.asIterator(request.getHeaderNames()); iterator.hasNext();){
            String name = iterator.next();
            headers.set(name, request.getHeader(name));
        }
        return "[headers = " + headers.toString()+"]";
    }

    public String params(){
        HttpServletRequest request = (HttpServletRequest)this.getRequest();
        String queryString = request.getQueryString();
        StringBuilder stringBuilder = new StringBuilder();
        if (StrUtil.isNotBlank(queryString)){
            stringBuilder
                    .append("queryString = ")
                    .append(queryString)
                    .append(",");
        }
        for (Iterator<String> iterator = IterUtil.asIterator(request.getParameterNames()); iterator.hasNext();){
            String name = iterator.next();
            stringBuilder
                    .append(name)
                    .append("=")
                    .append(request.getParameter(name))
                    .append(",");
        }
        return "[request param = " + stringBuilder.toString() + " request body = " + getMessagePayload() + "]";
    }

    private String getMessagePayload() {
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
