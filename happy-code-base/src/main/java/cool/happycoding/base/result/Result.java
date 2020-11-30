package cool.happycoding.base.result;

import cool.happycoding.base.common.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:51 下午
 */
@Data
public class Result implements Serializable {

    private String resultCode = ResultCode.SUCCESSFUL;
    private String resultMessage = ResultCode.SUCCESSFUL_MESSAGE;
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
}
