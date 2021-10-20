package cool.happycoding.code.base.context.header;

import cool.happycoding.code.base.context.ContextHolderStrategy;
import cool.happycoding.code.base.context.ThreadLocalContextHolderStrategy;

/**
 * description
 *
 * @author lanlanhappy 2021/10/19 1:18 下午
 */
public class HttpHeaderContextHolder {

    private volatile static ContextHolderStrategy<HttpHeaderContext> HTTP_CONTEXT
            = new ThreadLocalContextHolderStrategy<>();

    public static void setContext(HttpHeaderContext httpHeaderContext){
        HTTP_CONTEXT.setContext(httpHeaderContext);
    }

    public static void clearContext(){
        HTTP_CONTEXT.getContext().getHeaders().clear();
        HTTP_CONTEXT.clearContext();
    }

    public static HttpHeaderContext getContext(){
        return HTTP_CONTEXT.getContext();
    }


}
