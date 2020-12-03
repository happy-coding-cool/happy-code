package cool.happycoding.web.exception;

import cool.happycoding.base.common.ResultCode;
import cool.happycoding.base.result.BaseResult;
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
    public static BaseResult<ErrorDetail> build(ResultCode resultCode, String path){
        BaseResult<ErrorDetail> errorDetail = new BaseResult<>(resultCode);
        errorDetail.setData(ErrorDetail.builder().path(path).build());
        return errorDetail;
    }

    /**
     * 构造异常详情
     * @param resultCode
     * @param path
     * @param detail
     * @return
     */
    public static BaseResult<ErrorDetail> build(ResultCode resultCode, String path, Map<String, Object> detail){
        BaseResult<ErrorDetail> errorDetail = new BaseResult<>(resultCode);
        errorDetail.setData(ErrorDetail.builder().path(path).error(detail).build());
        return errorDetail;
    }

    /**
     * 构造异常详情
     * @param code
     * @param message
     * @param path
     * @param detail
     * @return
     */
    public static BaseResult<ErrorDetail> build(String code, String message, String path, Map<String, Object> detail){
        BaseResult<ErrorDetail> errorDetail = new BaseResult<>(code, message);
        errorDetail.setData(ErrorDetail.builder().path(path).error(detail).build());
        return errorDetail;
    }

}
