package cool.happycoding.code.base.util;

import cool.happycoding.code.base.common.ResultCode;
import cool.happycoding.code.base.exception.BizException;

/**
 * description
 *
 * @author lanlanhappy 2020/11/28 6:10 下午
 */
public final class HappyCodeUtil {

    /**
     * 用于对业务条件进行判断
     * @param condition
     * @param error
     */
    public static void check(boolean condition, ResultCode error) {
        if (condition) {
            throw new BizException(error);
        }
    }

}
