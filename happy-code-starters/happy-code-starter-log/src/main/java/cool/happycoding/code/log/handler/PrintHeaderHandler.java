package cool.happycoding.code.log.handler;

import com.alibaba.fastjson.JSONObject;
import cool.happycoding.code.log.wrapper.HappyServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     打印请求 header 内容
 * </p>
 *
 * @author lanlanhappy 2021/03/18 10:00 上午
 */
@Slf4j
public class PrintHeaderHandler extends AbstractPrintHandler{

    private final HappyServletRequestWrapper requestWrapper;
    public PrintHeaderHandler(HappyServletRequestWrapper requestWrapper){
        this.requestWrapper = requestWrapper;
    }

    @Override
    public void print() {
        log.info("*** *** request headers:{}", requestWrapper.headers());
    }
}
