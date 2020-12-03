package cool.happycoding.base.exception;

import cool.happycoding.base.common.HappyStatus;

import static com.google.common.collect.ImmutableMap.of;

/**
 * <p>未知的系统异常</p>
 *
 * @author lanlanhappy 2020/12/03 5:36 下午
 */
public class SystemException extends BizException {
    public SystemException(Throwable cause) {
        super(HappyStatus.INTERNAL_SYSTEM_ERROR, of("detail", cause.getMessage()), cause);
    }
}
