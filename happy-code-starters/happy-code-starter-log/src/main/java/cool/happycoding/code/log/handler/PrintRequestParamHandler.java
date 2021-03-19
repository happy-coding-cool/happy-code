package cool.happycoding.code.log.handler;

import cool.happycoding.code.log.wrapper.HappyServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     打印请求参数
 * </p>
 *
 * @author lanlanhappy 2021/03/18 10:01 上午
 */
@Slf4j
public class PrintRequestParamHandler extends AbstractPrintHandler{

    private final HappyServletRequestWrapper requestWrapper;
    public PrintRequestParamHandler(HappyServletRequestWrapper requestWrapper){
        this.requestWrapper = requestWrapper;
    }

    @Override
    public void print() {
        log.info("*** request context type:{}, body:{}", requestWrapper.getContentType(), requestWrapper.params());
    }
}
