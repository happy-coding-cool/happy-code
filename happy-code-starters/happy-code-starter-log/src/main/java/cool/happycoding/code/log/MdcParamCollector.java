package cool.happycoding.code.log;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 9:13 上午
 */
public interface MdcParamCollector {

    /**
     * 需要放置到mdc上下文中的参数内容
     * @param request
     * @return
     */
    Map<String, String> mdcParams(HttpServletRequest request);

}
