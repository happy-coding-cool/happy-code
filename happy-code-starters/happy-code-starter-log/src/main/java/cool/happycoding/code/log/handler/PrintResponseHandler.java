package cool.happycoding.code.log.handler;

import cool.happycoding.code.log.wrapper.HappyServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     打印 response
 * </p>
 *
 * @author lanlanhappy 2021/03/18 10:02 上午
 */
@Slf4j
public class PrintResponseHandler extends AbstractPrintHandler{

    private final HappyServletResponseWrapper responseWrapper;
    public PrintResponseHandler(HappyServletResponseWrapper responseWrapper){
        this.responseWrapper = responseWrapper;
    }

    @Override
    public void print() {
        log.info("*** *** response context type:{}  body :{}", responseWrapper.getContentType(), responseWrapper.response());
    }
}
