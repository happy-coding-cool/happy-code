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
     * 执行时间超过3s，则打出警告日志
     */
    long WARN_TIME_INTERVAL_MILLS = 3000;
}
