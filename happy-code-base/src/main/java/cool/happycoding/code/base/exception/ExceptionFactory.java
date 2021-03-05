package cool.happycoding.code.base.exception;

import cool.happycoding.code.base.common.ResultCode;

/**
 * description
 *
 * @author lanlanhappy 2021/03/05 3:30 下午
 */
public class ExceptionFactory {

    public static BizException exception(ResultCode error){
        return new BizException(error.getCode(), error.getMessage());
    }

    public static BizException exception(ResultCode error, Throwable throwable){
        return new BizException(error.getCode(), error.getMessage(), throwable);
    }

    public static SystemException systemException(ResultCode error){
        return systemException(error.getCode(), error.getMessage());
    }

    public static SystemException systemException(ResultCode error, Throwable throwable){
        return systemException(error.getCode(), error.getMessage(), throwable);
    }

    public static SystemException systemException(String errorMessage) {
        return new SystemException(errorMessage);
    }

    public static SystemException systemException(String errorCode, String errorMessage) {
        return new SystemException(errorCode, errorMessage);
    }

    public static SystemException systemException(String errorMessage, Throwable e) {
        return new SystemException(errorMessage, e);
    }

    public static SystemException systemException(String errorCode, String errorMessage, Throwable e) {
        return new SystemException(errorCode, errorMessage, e);
    }
}
