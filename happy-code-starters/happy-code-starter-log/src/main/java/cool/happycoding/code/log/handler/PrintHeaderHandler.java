package cool.happycoding.code.log.handler;

import cool.happycoding.code.log.wrapper.HappyServletRequestWrapper;

/**
 * <p>
 *     打印请求 header 内容
 * </p>
 *
 * @author lanlanhappy 2021/03/18 10:00 上午
 */
public class PrintHeaderHandler extends AbstractPrintHandler{

    private final HappyServletRequestWrapper requestWrapper;
    public PrintHeaderHandler(HappyServletRequestWrapper requestWrapper){
        this.requestWrapper = requestWrapper;
    }

    @Override
    public void print() {

    }
}
