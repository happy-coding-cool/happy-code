package cool.happycoding.base.common;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:52 下午
 */
public interface ResultCode extends CodeMessage {

    String SUCCESSFUL = "0";
    String SUCCESSFUL_MESSAGE = "success";

    String FAILURE = "1";
    String FAILURE_MESSAGE = "failure";

    String UNKNOWN_EXCEPTION = "9999";
    String UNKNOWN_EXCEPTION_MESSAGE = "unknown exception";

}
