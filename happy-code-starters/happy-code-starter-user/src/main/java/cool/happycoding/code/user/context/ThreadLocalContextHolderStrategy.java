package cool.happycoding.code.user.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:13 下午
 */
public class ThreadLocalContextHolderStrategy<Context> implements ContextHolderStrategy<Context>{

    private final ThreadLocal<Context> contextHolder = new TransmittableThreadLocal<>();

    @Override
    public void clearContext() {
        contextHolder.remove();
    }

    @Override
    public Context getContext() {
        return contextHolder.get();
    }

    @Override
    public void setContext(Context context) {
        contextHolder.set(context);
    }
}
