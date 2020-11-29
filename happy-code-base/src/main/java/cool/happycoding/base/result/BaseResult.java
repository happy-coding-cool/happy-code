package cool.happycoding.base.result;

import cool.happycoding.base.common.ResultCode;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:54 下午
 */
public class BaseResult<T> extends Result {

    private T data;

    public BaseResult(){
        super();
    }

    public BaseResult(T data){
        super();
        this.data =  data;
    }

    public BaseResult(ResultCode resultCode, T data){
        super(resultCode);
        this.data = data;
    }

    public BaseResult(String code, String message){
        super(code, message);
    }

    public BaseResult(ResultCode resultCode){
        super(resultCode);
    }

    public static  BaseResult<?> success(){
        return new BaseResult<>(ResultCode.SUCCESSFUL);
    }

    public static <T> BaseResult<T> success(T data){
        return new BaseResult<T>(data);
    }

    public static  BaseResult<?> success(String code, String message){
        return new BaseResult<>(code, message);
    }

    public static  BaseResult<?> fail(ResultCode resultCode){
        return new BaseResult<>(resultCode);
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
