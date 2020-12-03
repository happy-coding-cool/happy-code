package cool.happycoding.web.exception;

import cn.hutool.core.collection.CollUtil;
import cool.happycoding.base.common.HappyStatus;
import cool.happycoding.base.exception.BizException;
import cool.happycoding.base.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.hutool.core.util.StrUtil.isEmpty;
import static cool.happycoding.base.common.HappyStatus.REQUEST_VALIDATION_FAILED;

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

    /**
     * 配合validator组件实现入参的校验
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public BaseResult<ErrorDetail> handleInvalidRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {

        String path = request.getRequestURI();
        Map<String, Object> error = ex.getBindingResult()
                .getFieldErrors().stream()
                // 解决 key 值相同的问题
                .collect(Collectors.groupingBy(FieldError::getField))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry->validMessage(entry.getValue())));

        log.error("Validation error for [{}]: {}", ex.getParameter().getParameterType().getName(), error);
        log.error("exception:", ex);
        return ErrorDetail.build(REQUEST_VALIDATION_FAILED, path, error);
    }

    private String validMessage(List<FieldError> errorList){
        if (CollUtil.isEmpty(errorList)){
            return "无错误提示";
        } else {
            return errorList.stream().map(fieldError -> {
                String message = fieldError.getDefaultMessage();
                return isEmpty(message) ? "无错误提示" : message;
            }).collect(Collectors.joining("；"));
        }
    }

    /**
     * 不确定异常类型的拦截处理
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public BaseResult<ErrorDetail> handleGeneralException(Throwable ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        log.error("exception: ", ex);
        return ErrorDetail.build(HappyStatus.INTERNAL_SYSTEM_ERROR, path);
    }

}
