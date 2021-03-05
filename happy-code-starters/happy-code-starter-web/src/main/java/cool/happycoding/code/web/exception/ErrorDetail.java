package cool.happycoding.code.web.exception;

import cool.happycoding.code.base.common.ResultCode;
import cool.happycoding.code.base.result.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>异常信息定义</p>
 *
 * @author lanlanhappy 2020/11/30 9:09 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail implements Serializable {

    private String path;
    private Map<String, Object> error;

    /**
     * 构造异常详情
     * @param resultCode
     * @param path
     * @return
     */
    public static Result error(ResultCode resultCode, String path){
        return error(resultCode, path, null);
    }

    /**
     * 构造异常详情
     * @param resultCode
     * @param path
     * @param detail
     * @return
     */
    public static Result error(ResultCode resultCode, String path, Map<String, Object> detail){
        return error(resultCode.getCode(), resultCode.getMessage(), path, detail);
    }

    /**
     * 构造异常详情
     * @param code
     * @param message
     * @param path
     * @param detail
     * @return
     */
    public static Result error(String code, String message, String path, Map<String, Object> detail){
        Result result = Result.failure(code, message);
        result.setErrorData(ErrorDetail.builder().path(path).error(detail).build());
        return result;
    }

}
