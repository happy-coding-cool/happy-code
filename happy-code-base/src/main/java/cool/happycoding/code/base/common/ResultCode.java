package cool.happycoding.code.base.common;

/**
 * <p>
 *     返回状态描述
 * </p>
 *
 * @author lanlanhappy 2020/11/28 6:06 下午
 */
public interface ResultCode {

    String SUCCESSFUL = "0";
    String SUCCESSFUL_MESSAGE = "success";

    String FAILURE = "1";
    String FAILURE_MESSAGE = "failure";

    String UNKNOWN_EXCEPTION = "9999";
    String UNKNOWN_EXCEPTION_MESSAGE = "unknown exception";

    /**
     * result code
     * @return code
     */
    String getCode();

    /**
     * result message
     * @return message
     */
    String getMessage();
}
