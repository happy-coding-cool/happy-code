package cool.happycoding.code.log;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 9:31 上午
 */
public class DefaultMdcParamCollector implements MdcParamCollector{

    @Override
    public Map<String, String> mdcParams() {
        Map<String, String> mdcParams = Maps.newHashMap();
        mdcParams.put("trace-id", IdUtil.fastSimpleUUID());
        return mdcParams;
    }
}
