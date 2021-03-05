package cool.happycoding.code.base.exception;

import cn.hutool.core.collection.CollUtil;
import cool.happycoding.code.base.common.ResultCode;

import java.util.Collection;

/**
 * Assertion utility class that assists in validating arguments.
 *
 * <p>Useful for identifying programmer errors early and clearly at runtime.
 *
 * <p>For example, if the contract of a public method states it does not
 * allow {@code null} arguments, {@code Assert} can be used to validate that
 * contract.
 *
 * For example:
 *
 * <pre class="code">
 * Assert.notNull(clazz, "The class must not be null");
 * Assert.isTrue(i > 0, "The value must be greater than zero");</pre>
 *
 * This class is empowered by  {@link org.springframework.util.Assert}
 *
 * @author Frank Zhang
 * @date 2019-01-13 11:49 AM
 */
public abstract class Assert {

    private static final String DEFAULT_ERR_CODE = "BIZ_ERROR";

    public static void isNull(Object object, ResultCode resultCode) {
        isNull(object, resultCode.getCode(), resultCode.getMessage());
    }

    public static void isNull(Object object, String errMessage) {
        isNull(object, DEFAULT_ERR_CODE, errMessage);
    }

    public static void isNull(Object object, String errorCode, String errMessage) {
        isTrue(object == null, errorCode, errMessage);
    }

    public static void isEmpty(Collection<?> collection, ResultCode resultCode) {
        isEmpty(collection, resultCode.getCode(), resultCode.getMessage());
    }

    public static void isEmpty(Collection<?> collection, String errMessage) {
        isEmpty(collection, DEFAULT_ERR_CODE, errMessage);
    }

    public static void isEmpty(Collection<?> collection, String errorCode, String errMessage) {
        isTrue(CollUtil.isEmpty(collection), errorCode, errMessage);
    }

    public static void isFalse(boolean expression, ResultCode resultCode) {
        isFalse(expression, resultCode.getCode(), resultCode.getMessage());
    }

    public static void isFalse(boolean expression, String errMessage) {
        isFalse(expression, DEFAULT_ERR_CODE, errMessage);
    }

    public static void isFalse(boolean expression, String errorCode, String errMessage) {
        isTrue(!expression, errorCode, errMessage);
    }

    public static void isTrue(boolean expression,ResultCode resultCode){
        isTrue(expression, resultCode.getCode(), resultCode.getMessage());
    }

    public static void isTrue(boolean expression, String errMessage) {
        isTrue(expression, DEFAULT_ERR_CODE, errMessage);
    }

    /**
     * Assert a boolean expression, throwing {@code BizException}
     * @param expression a boolean expression
     * @param errorCode
     * @param errMessage the exception message to use if the assertion fails
     * @throws BizException if expression is {@code true}
     */
    public static void isTrue(boolean expression, String errorCode, String errMessage) {
        if (expression) {
            throw new BizException(errorCode, errMessage);
        }
    }

}
