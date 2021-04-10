package cool.happycoding.code.log.trace;

import cn.hutool.core.util.IdUtil;
import org.slf4j.MDC;

/**
 * description
 *
 * @author lanlanhappy 2021/04/10 4:57 下午
 */
public final class MDCTraceUtil {

    /**
     * 追踪id的名称
     */
    public static final String KEY_TRACE_ID = "trace-id";

    /**
     * 日志链路追踪id信息头
     */
    public static final String TRACE_ID_HEADER = "x-trace-id";


    /**
     * 创建traceId并赋值MDC
     */
    public static void addTraceId() {
        MDC.put(KEY_TRACE_ID, IdUtil.fastSimpleUUID());
    }

    /**
     * 赋值MDC
     */
    public static void putTraceId(String traceId) {
        MDC.put(KEY_TRACE_ID, traceId);
    }

    /**
     * 获取MDC中的traceId值
     */
    public static String getTraceId() {
        return MDC.get(KEY_TRACE_ID);
    }

    /**
     * 清除MDC的值
     */
    public static void removeTraceId() {
        MDC.remove(KEY_TRACE_ID);
    }

    /**
     * 清空MDC
     */
    public static void clear(){
        MDC.clear();
    }
}
