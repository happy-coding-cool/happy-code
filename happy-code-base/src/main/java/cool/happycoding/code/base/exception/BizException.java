package cool.happycoding.code.base.exception;


/**
 * description
 *
 * @author lanlanhappy 2020/11/28 6:05 下午
 */
public class BizException extends BaseException{

    public BizException(String errMessage) {
        super(errMessage);
    }

    public BizException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public BizException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public BizException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
