package cool.happycoding.code.web.fastjson;

import com.alibaba.fastjson.support.config.FastJsonConfig;

/**
 * description
 *
 * @author lanlanhappy 2021/03/03 10:57 上午
 */
@FunctionalInterface
public interface FastJsonConfigCustomizer {
    /**
     * 加载 个性化序列化/反序列化的配置
     * @param fastJsonConfig
     */
    void customize(FastJsonConfig fastJsonConfig);
}
