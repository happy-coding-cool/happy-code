package cool.happycoding.code.base.result;

import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2021/11/05 1:22 下午
 */
@Data
public class Response <T> implements Serializable {

    private String code;
    private String msg;
    private Long timestamp;
    private T data;


}
