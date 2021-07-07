package cool.happycoding.code.web.exception;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.common.HappyStatus;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.base.exception.UnauthorizedException;
import cool.happycoding.code.base.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.hutool.core.util.StrUtil.isEmpty;
import static cool.happycoding.code.base.common.HappyStatus.REQUEST_VALIDATION_FAILED;

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

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        String path = getRequestPath(request);
        Map<String, Object> error = ex.getConstraintViolations()
                .stream()
                // 解决 key 值相同的问题
                .collect(Collectors.groupingBy(cv->cv.getPropertyPath().toString()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry->constraint(entry.getValue())));
        log.error("Validation error:{}", error);
        log.error("exception: ", ex);
        return ErrorDetail.error(REQUEST_VALIDATION_FAILED, path, error);
    }

    private String constraint(List<ConstraintViolation<?>> errorList){
        if (CollUtil.isEmpty(errorList)){
            return "无错误提示";
        }else{
            return errorList.stream().map(fieldError -> {
                String message = fieldError.getMessage();
                return isEmpty(message) ? "无错误提示" : message;
            }).collect(Collectors.joining("；"));
        }
    }

    /**
     * 统一处理 BizException
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Result handleAppException(BizException ex, HttpServletRequest request) {
        log.error("exception:", ex);
        return ErrorDetail.error(ex.getErrCode(), ex.getErrMessage(), getRequestPath(request));
    }

    /**
     * 配合validator组件实现入参的校验
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleInvalidRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {

        String path = getRequestPath(request);
        Map<String, Object> error = ex.getBindingResult()
                .getFieldErrors().stream()
                // 解决 key 值相同的问题
                .collect(Collectors.groupingBy(FieldError::getField))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry->validMessage(entry.getValue())));

        log.error("Validation error for [{}]: {}", ex.getParameter().getParameterType().getName(), error);
        log.error("exception:", ex);
        return ErrorDetail.error(REQUEST_VALIDATION_FAILED, path, error);
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
    public Result handleGeneralException(Throwable ex, HttpServletRequest request) {
        String path = getRequestPath(request);
        log.error("exception: ", ex);
        return ErrorDetail.error(HappyStatus.INTERNAL_SYSTEM_ERROR, path);
    }

    /**
     * 对401单独处理
     * @param ex
     * @param request
     * @return
     */
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleUnauthorizedException(UnauthorizedException ex, HttpServletRequest request) {
        String path = getRequestPath(request);
        log.error("exception: ", ex);
        return ErrorDetail.error(ex.getErrCode(), ex.getErrMessage(), getRequestPath(request));
    }

    private String getRequestPath(HttpServletRequest request){

        // 解决error控制器中抛出异常时，获取request path 不准确的问题
        Object errorPath = request.getAttribute("javax.servlet.error.request_uri");
        if (ObjectUtil.isNotNull(errorPath)){
            return errorPath.toString();
        }

        return request.getRequestURI();
    }

}
