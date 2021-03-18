package cool.happycoding.code.log.filter;

import cn.hutool.core.date.TimeInterval;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 *     计算每个请求花费的时间
 * </p>
 *
 * @author lanlanhappy 2020/12/07 8:48 下午
 */
@Slf4j
public class TimeIntervalFilter implements Filter {


    /**
     * 执行时间超过3s，则打出警告日志
     */
    private static final long WARN_TIME_INTERVAL_MILLS = 3000;

    /**
     * 计算方法执行时间
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        TimeInterval interval = new TimeInterval();
        final String requestUri = ((HttpServletRequest)request).getRequestURI();
        chain.doFilter(request, response);
        long mills = interval.intervalMs();
        // 超过 3s 打出警告日志
        if (mills > WARN_TIME_INTERVAL_MILLS){
            log.warn("RequestUri:[{}] , execute spend:[{}]ms, more than:[{}]ms 请优化程序逻辑!", requestUri, mills, WARN_TIME_INTERVAL_MILLS);
        }else{
            log.info("RequestUri:[{}] , execute spend:[{}]ms", requestUri, mills);
        }
    }
}

