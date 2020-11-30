package cool.happycoding.web.exception;

import cool.happycoding.base.exception.BizException;
import cool.happycoding.base.exception.ErrorDetail;
import cool.happycoding.base.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *     统一的异常拦截处理
 * </p>
 *
 * @author lanlanhappy 2020/11/30 1:45 下午
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一处理 BizException
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public BaseResult<ErrorDetail> handleAppException(BizException ex, HttpServletRequest request) {
        log.error("exception:", ex);
        return ErrorDetail.build(ex.getError(), request.getRequestURI(), ex.getErrorData());
    }

}
