package cool.happycoding.code.base.result;

import cool.happycoding.code.base.common.HappyStatus;
import cool.happycoding.code.base.common.ResultCode;
import cool.happycoding.code.base.pojo.DTO;
import lombok.Data;

import java.util.Optional;

import static cool.happycoding.code.base.util.HappyCodeUtil.status;

/**
 * description
 *
 * @author lanlanhappy 2021/11/05 1:22 下午
 */
@Data
public class Response <T> extends DTO {

    private String status;
    private String code;
    private String msg;
    private Long timestamp;
    private T data;

    public Response(){
        this.timestamp = System.currentTimeMillis();
    }

    public Response(ResultCode resultCode){
        resultCode = Optional.of(resultCode).orElse(HappyStatus.FAILURE);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.timestamp = System.currentTimeMillis();
        this.status = status(resultCode.getCode());
    }

    public <T> Response<T> ok(T data){
        return response(data, HappyStatus.SUCCESSFUL);
    }

    public <T> Response<T> failed(String msg){
        return response(null, HappyStatus.FAILURE.getCode(), msg);
    }

    public <T> Response<T> failed(ResultCode resultCode){
        return response(null, resultCode);
    }

    public <T> Response<T> response(T data, ResultCode code){
        return response(data, code.getCode(), code.getMessage());
    }

    public <T> Response<T> response(T data, String code, String msg){
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        response.setStatus(status(code));
        return response;
    }

}
