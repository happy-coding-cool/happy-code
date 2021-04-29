package cool.happycoding.code.lock;

import cool.happycoding.code.base.exception.BizException;

/**
 * description
 *
 * @author lanlanhappy 2021/04/29 5:10 下午
 */
public class HappyLockException extends BizException {

    public HappyLockException(String errMessage) {
        super(errMessage);
    }

    public HappyLockException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public HappyLockException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public HappyLockException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
