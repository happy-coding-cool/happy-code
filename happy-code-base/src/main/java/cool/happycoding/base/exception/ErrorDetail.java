package cool.happycoding.base.exception;

import cool.happycoding.base.common.CodeMessage;
import cool.happycoding.base.result.BaseResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2020/11/30 9:09 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail implements Serializable {

    private String path;
    private Map<String, Object> detail;

    /**
     * 构造异常详情
     * @param codeMessage
     * @param path
     * @param detail
     * @return
     */
    public static BaseResult<ErrorDetail> build(CodeMessage codeMessage, String path, Map<String, Object> detail){
        BaseResult<ErrorDetail> errorDetail = new BaseResult<>(codeMessage);
        errorDetail.setData(ErrorDetail.builder().path(path).detail(detail).build());
        return errorDetail;
    }

}
