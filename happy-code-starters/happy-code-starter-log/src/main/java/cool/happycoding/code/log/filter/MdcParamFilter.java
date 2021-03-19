package cool.happycoding.code.log.filter;

import cool.happycoding.code.log.MdcParamCollector;
import org.slf4j.MDC;

import javax.servlet.*;
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
            mdcParamCollector.mdcParams()
                    .forEach(MDC::put);
            chain.doFilter(request, response);
        }finally {
            MDC.clear();
        }
    }
}
