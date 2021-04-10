package cool.happycoding.code.log.filter;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.log.MdcParamCollector;
import cool.happycoding.code.log.trace.MDCTraceUtil;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 设置MDC打印参数
 *
 * @author lanlanhappy 2021/03/18 9:06 上午
 */
public class MdcParamFilter implements Filter {

    private final MdcParamCollector mdcParamCollector;

    public MdcParamFilter(MdcParamCollector mdcParamCollector){
        this.mdcParamCollector = mdcParamCollector;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            String traceId = httpServletRequest.getHeader(MDCTraceUtil.TRACE_ID_HEADER);
            if (StrUtil.isNotBlank(traceId)){
                MDCTraceUtil.putTraceId(traceId);
            }else{
                MDCTraceUtil.addTraceId();
            }
            mdcParamCollector.mdcParams(httpServletRequest)
                    .forEach(MDC::put);
            chain.doFilter(request, response);
        }finally {
            MDCTraceUtil.clear();
        }
    }
}
