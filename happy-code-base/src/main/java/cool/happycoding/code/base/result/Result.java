package cool.happycoding.code.base.result;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.common.HappyStatus;
import cool.happycoding.code.base.common.ResultCode;
import lombok.Data;

import java.io.Serializable;

import static cool.happycoding.code.base.common.HappyStatus.FAILURE;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:51 下午
 */
@Data
public class Result implements Serializable {

    private String resultCode = ResultCode.SUCCESSFUL;
    private String resultMessage = ResultCode.SUCCESSFUL_MESSAGE;
    private Object errorData;
    private Long timestamp;

    public Result(){
        this.timestamp = System.currentTimeMillis();
    }

    public Result (ResultCode resultCode){
        this.resultCode = resultCode.getCode();
        this.resultMessage = resultCode.getMessage();
        this.timestamp = System.currentTimeMillis();
    }

    public Result (String code, String message){
        this.resultCode = code;
        this.resultMessage = message;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean isSuccess() {
        return StrUtil.equalsAnyIgnoreCase(resultCode, ResultCode.SUCCESSFUL);
    }

    public static Result error(ResultCode resultCode, Object errorData){
        Result result = new Result(resultCode);
        result.setErrorData(errorData);
        return result;
    }

    public static Result error(Object errorData){
        return error(FAILURE,errorData);
    }

    public static Result success() {
        return new Result(HappyStatus.SUCCESSFUL);
    }

    public static Result failure(String errCode, String errMessage) {
        return new Result(errCode, errMessage);
    }
}
