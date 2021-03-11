package cool.happycoding.code.base.context;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:13 下午
 */
public interface ContextHolderStrategy<Context> {

    /**
     * 清除上下文
     */
    void clearContext();

    /**
     * 获取上下文
     * @return
     */
    Context getContext();

    /**
     * 删除上下文
     * @param context
     */
    void setContext(Context context);

}
