package cool.happycoding.code.feign;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.context.header.HttpHeaderContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.List;

import static cool.happycoding.code.base.util.HappyCodeUtil.nullToEmpty;

/**
 * description
 *
 * @author lanlanhappy 2021/10/19 1:32 下午
 */
public class FeignHeaderInterceptor implements RequestInterceptor {

    private final List<FeignHeaderCustomizer> customizers;
    private final HappyCodeFeignProperties happyCodeFeignProperties;

    public FeignHeaderInterceptor(List<FeignHeaderCustomizer> customizers, HappyCodeFeignProperties happyCodeFeignProperties){
        this.customizers = customizers;
        this.happyCodeFeignProperties = happyCodeFeignProperties;
    }

    @Override
    public void apply(RequestTemplate template) {

        List<String> headers = nullToEmpty(happyCodeFeignProperties.getHeaders());
        HttpHeaderContextHolder.getContext().getHeaders()
                .entrySet().stream()
                .filter(entry -> headers.contains(entry.getKey()) && StrUtil.isNotBlank(entry.getValue()))
                .forEach(entry -> template.header(entry.getKey(), entry.getValue()));

        nullToEmpty(customizers).forEach(customizer->customizer.customize(template));
    }
}
