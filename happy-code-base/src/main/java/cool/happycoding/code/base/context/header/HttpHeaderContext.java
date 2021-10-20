package cool.happycoding.code.base.context.header;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/10/19 1:16 下午
 */
@Data
public class HttpHeaderContext implements Serializable {

    private Map<String, String> headers;
}
