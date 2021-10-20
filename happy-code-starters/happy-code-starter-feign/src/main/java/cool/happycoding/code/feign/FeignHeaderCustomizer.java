package cool.happycoding.code.feign;

import feign.RequestTemplate;

/**
 * description
 *
 * @author lanlanhappy 2021/10/19 1:33 下午
 */
@FunctionalInterface
public interface FeignHeaderCustomizer {

    /**
     * config customer http header
     * @param requestTemplate
     */
    void customize(RequestTemplate requestTemplate);
}
