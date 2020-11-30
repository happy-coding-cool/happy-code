package cool.happycoding.base.result;

import cool.happycoding.base.common.CodeMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:51 下午
 */
@Data
public class Result implements Serializable {

    private String resultCode = CodeMessage.SUCCESSFUL;
    private String resultMessage = CodeMessage.SUCCESSFUL_MESSAGE;
    private Long timestamp;

    public Result(){
        this.timestamp = System.currentTimeMillis();
    }

    public Result (CodeMessage codeMessage){
        this.resultCode = codeMessage.getCode();
        this.resultMessage = codeMessage.getMessage();
        this.timestamp = System.currentTimeMillis();
    }

    public Result (String code, String message){
        this.resultCode = code;
        this.resultMessage = message;
        this.timestamp = System.currentTimeMillis();
    }
}
