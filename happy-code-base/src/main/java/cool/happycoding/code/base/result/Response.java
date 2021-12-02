package cool.happycoding.code.base.result;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.common.HappyStatus;
import cool.happycoding.code.base.common.ResultCode;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.base.pojo.DTO;
import lombok.Data;
import org.springframework.context.MessageSource;

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

    @SuppressWarnings("all")
    public Response(ResultCode resultCode){
        resultCode = Optional.of(resultCode).orElse(HappyStatus.FAILURE);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.timestamp = System.currentTimeMillis();
        this.status = status(resultCode.getCode());
    }

    public Response<T> ok(T data){
        return response(data, HappyStatus.SUCCESSFUL);
    }

    public Response<T> failed(String msg){
        return response(null, HappyStatus.FAILURE.getCode(), msg);
    }

    public Response<T> failed(ResultCode resultCode){
        return response(null, resultCode);
    }

    public Response<T> failed(MessageSource messageSource, ResultCode resultCode){
        return response(null, messageSource, resultCode);
    }

    public Response<T> failed(Object[] args, MessageSource messageSource, ResultCode resultCode){
        return response(null, args, messageSource, resultCode);
    }

    public Response<T> response(T data, ResultCode resultCode){
        return response(data, resultCode.getCode(), resultCode.getMessage());
    }

    public Response<T> response(T data, MessageSource messageSource, ResultCode resultCode){
        return response(data, null, messageSource, resultCode);
    }

    public Response<T> response(T data, Object[] args, MessageSource messageSource, ResultCode resultCode){
        return response(data, resultCode.getCode(), resultCode.getMessage(args, messageSource));
    }

    public Response<T> response(T data, String code, String msg){
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        response.setStatus(status(code));
        return response;
    }

    public boolean ok(){
        return check(HappyStatus.SUCCESSFUL.getCode());
    }

    public boolean check(String code){
        return StrUtil.equalsIgnoreCase(code, this.code);
    }

    public T restData(){
        if (ok()){
            return this.data;
        }
        throw new BizException(this.msg);
    }
}
