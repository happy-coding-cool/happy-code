package cool.happycoding.base.result;

import cool.happycoding.base.common.CodeMessage;

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

    public BaseResult(CodeMessage codeMessage, T data){
        super(codeMessage);
        this.data = data;
    }

    public BaseResult(String code, String message){
        super(code, message);
    }

    public BaseResult(CodeMessage codeMessage){
        super(codeMessage);
    }

    public static  BaseResult<?> success(){
        return new BaseResult<>(CodeMessage.SUCCESSFUL);
    }

    public static <T> BaseResult<T> success(T data){
        return new BaseResult<T>(data);
    }

    public static  BaseResult<?> success(String code, String message){
        return new BaseResult<>(code, message);
    }

    public static  BaseResult<?> fail(CodeMessage codeMessage){
        return new BaseResult<>(codeMessage);
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
