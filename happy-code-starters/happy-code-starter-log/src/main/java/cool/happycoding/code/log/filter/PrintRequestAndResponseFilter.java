package cool.happycoding.code.log.filter;

import cool.happycoding.code.log.HappyLogProperties;
import cool.happycoding.code.log.handler.PrintHeaderHandler;
import cool.happycoding.code.log.handler.PrintRequestParamHandler;
import cool.happycoding.code.log.handler.PrintResponseHandler;
import cool.happycoding.code.log.wrapper.HappyServletRequestWrapper;
import cool.happycoding.code.log.wrapper.HappyServletResponseWrapper;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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
public class PrintRequestAndResponseFilter extends OncePerRequestFilter {

    private final HappyLogProperties happyLogProperties;

    public PrintRequestAndResponseFilter(HappyLogProperties happyLogProperties){
        this.happyLogProperties = happyLogProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        if (!match(requestUri, happyLogProperties.getExcludes())){
            HappyServletRequestWrapper requestWrapper = new HappyServletRequestWrapper(request);
            HappyServletResponseWrapper responseWrapper = new HappyServletResponseWrapper(response);
            filterChain.doFilter(requestWrapper, responseWrapper);
            if (happyLogProperties.isEnablePrintHeader()){
                new PrintHeaderHandler(requestWrapper).print();
            }
            if (happyLogProperties.isEnablePrintRequest()){
                new PrintRequestParamHandler(requestWrapper).print();
            }
            if (happyLogProperties.isEnablePrintResponse()){
                new PrintResponseHandler(responseWrapper).print();
            }
            responseWrapper.copyBodyToResponse();
        }else{
            filterChain.doFilter(request, response);
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
