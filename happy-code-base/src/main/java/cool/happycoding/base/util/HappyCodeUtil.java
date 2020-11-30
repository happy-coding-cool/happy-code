package cool.happycoding.base.util;

import cool.happycoding.base.common.ResultCode;
import cool.happycoding.base.exception.BizException;

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
