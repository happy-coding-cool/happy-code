package cool.happycoding.code.base.exception;

import lombok.Data;

/**
 * description
 *
 * @author lanlanhappy 2021/03/05 3:32 下午
 */
@Data
public class BaseException extends RuntimeException{

    private String errCode;
    private String errMessage;

    public BaseException(String errMessage) {
        super(errMessage);
    }
    public BaseException(String errMessage, Throwable throwable) {
        super(errMessage, throwable);
    }

    public BaseException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
    }

    public BaseException(String errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
    }
}
