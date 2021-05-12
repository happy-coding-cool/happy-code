package cool.happycoding.code.web;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:02 下午
 */
public interface Constants {

    /**
     * DateTime 格式化字符串
     * <p>年-月-日 时:分:秒（标准北京时间）
     */
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * happy code 统一线程池定义 运用 com.alibaba.ttl.threadpool.TtlExecutors 保证threadcontext传递
     */
    String HAPPY_THREAD_POOL_EXECUTOR = "happyThreadPoolExecutor";
}
