package cool.happycoding.code.base.exception;

/**
 * <p>未知的系统异常</p>
 *
 * @author lanlanhappy 2020/12/03 5:36 下午
 */
public class SystemException extends BaseException {

    private static final String DEFAULT_ERR_CODE = "SYS_ERROR";

    public SystemException(String errMessage) {
        super(DEFAULT_ERR_CODE, errMessage);
    }

    public SystemException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public SystemException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE, errMessage, e);
    }

    public SystemException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }

}
