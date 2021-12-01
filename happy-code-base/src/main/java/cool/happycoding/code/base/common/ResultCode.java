package cool.happycoding.code.base.common;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Objects;

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

    String STATUS_OK = "ok";
    String STATUS_FAIL = "failed";
    String STATUS_UNKNOWN = "unknown";

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

    /**
     * 支持国际化
     * @param args format args
     * @param messageSource messageSource
     * @return message
     */
    default String getMessage(Object[] args, MessageSource messageSource){
        return Objects.isNull(messageSource) ? getMessage()
                : messageSource.getMessage(getCode(), args, LocaleContextHolder.getLocale());
    }
}
