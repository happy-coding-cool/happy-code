package cool.happycoding.base.exception;

import cn.hutool.core.map.MapUtil;
import cool.happycoding.base.common.ResultCode;
import lombok.Data;

import java.util.Map;

import static cn.hutool.core.collection.CollUtil.isEmpty;


/**
 * description
 *
 * @author lanlanhappy 2020/11/28 6:05 下午
 */
@Data
public class BizException extends RuntimeException{

    private ResultCode error;
    private Map<String, Object> errorData = MapUtil.newHashMap();

    public BizException(ResultCode error){
        super(format(error.getCode(), error.getMessage(), MapUtil.newHashMap()));
        this.error = error;
    }

    public BizException(String code, String message){
        super(format(code, message, null));
        this.error = new ResultCode() {
            @Override
            public String getCode() {
                return code;
            }
            @Override
            public String getMessage() {
                return message;
            }
        };
    }

    public BizException(ResultCode error, Map<String, Object> errorData){
        super(format(error.getCode(), error.getMessage(), errorData));
        this.errorData = errorData;
        this.error = error;
    }

    public BizException(ResultCode error, Throwable throwable){
        super(error.getMessage(), throwable);
        this.error = error;
    }

    public BizException(ResultCode error, Map<String, Object> errorData, Throwable throwable){
        super(format(error.getCode(), error.getMessage(), errorData), throwable);
        this.error = error;
    }

    public static BizException exception(ResultCode error){
        return new BizException(error);
    }

    public static BizException exception(ResultCode error, Throwable throwable){
        return new BizException(error, throwable);
    }

    public static BizException exception(ResultCode error, Map<String, Object> errorData){
        return new BizException(error, errorData);
    }

    public static BizException exception(ResultCode error, Map<String, Object> errorData, Throwable throwable){
        return new BizException(error, errorData, throwable);
    }
    private static String format(String code, String message, Map<String, Object> data) {
        return String.format("[status] %s, %s: %s.", code, message, isEmpty(data) ? "" : data.toString());
    }
}
