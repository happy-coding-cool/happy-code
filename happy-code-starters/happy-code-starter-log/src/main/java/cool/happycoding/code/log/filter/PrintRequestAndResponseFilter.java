package cool.happycoding.code.log.filter;

import cool.happycoding.code.log.HappyLogProperties;
import cool.happycoding.code.log.handler.PrintHeaderHandler;
import cool.happycoding.code.log.handler.PrintRequestParamHandler;
import cool.happycoding.code.log.handler.PrintResponseHandler;
import cool.happycoding.code.log.wrapper.HappyServletRequestWrapper;
import cool.happycoding.code.log.wrapper.HappyServletResponseWrapper;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *     打印 请求/响应 数据
 * </p>
 *
 * @author lanlanhappy 2021/03/18 9:58 上午
 */
public class PrintRequestAndResponseFilter implements Filter {

    private final HappyLogProperties happyLogProperties;

    public PrintRequestAndResponseFilter(HappyLogProperties happyLogProperties){
        this.happyLogProperties = happyLogProperties;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        String requestUri = httpServletRequest.getRequestURI();
        if (!match(requestUri, happyLogProperties.getExcludes())){
            // TODO 需要打印
            HappyServletRequestWrapper requestWrapper = new HappyServletRequestWrapper(httpServletRequest);
            HappyServletResponseWrapper responseWrapper = new HappyServletResponseWrapper(httpServletResponse);
            chain.doFilter(requestWrapper, responseWrapper);
            if (happyLogProperties.isEnablePrintHeader()){
                new PrintHeaderHandler(requestWrapper).print();
            }
            if (happyLogProperties.isEnablePrintRequest()){
                new PrintRequestParamHandler(requestWrapper).print();
            }
            if (happyLogProperties.isEnablePrintResponse()){
                new PrintResponseHandler(responseWrapper).print();
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    private boolean match(String uri, List<String> excludes) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String url : excludes) {
            if (antPathMatcher.match(url, uri)) {
                return true;
            }
        }
        return false;
    }
}
