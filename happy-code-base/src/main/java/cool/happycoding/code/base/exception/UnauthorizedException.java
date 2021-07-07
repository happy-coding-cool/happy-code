package cool.happycoding.code.base.exception;

/**
 * description
 *
 * @author lanlanhappy 2021/07/07 11:35 上午
 */
public class UnauthorizedException extends BizException{

    public UnauthorizedException(String errMessage) {
        super(errMessage);
    }

    public UnauthorizedException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public UnauthorizedException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }

}
