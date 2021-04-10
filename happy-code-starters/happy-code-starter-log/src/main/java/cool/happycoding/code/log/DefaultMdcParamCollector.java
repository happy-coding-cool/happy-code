package cool.happycoding.code.log;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 9:31 上午
 */
public class DefaultMdcParamCollector implements MdcParamCollector{

    @Override
    public Map<String, String> mdcParams(HttpServletRequest request) {
        return Maps.newHashMap();
    }
}
