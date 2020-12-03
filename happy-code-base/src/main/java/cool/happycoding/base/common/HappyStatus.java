package cool.happycoding.base.common;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 9:39 下午
 */
public enum  HappyStatus implements ResultCode {
    /**
     * 参数校验失败
     */
    REQUEST_VALIDATION_FAILED("400", "请求数据验证失败"),
    /**
     * 系统错误
     */
    INTERNAL_SYSTEM_ERROR("500","系统错误")
    ;
    String code;
    String message;

    HappyStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
