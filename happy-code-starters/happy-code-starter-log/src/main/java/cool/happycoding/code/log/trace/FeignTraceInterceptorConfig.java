package cool.happycoding.code.log.trace;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.log.HappyLogProperties;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * description
 *
 * @author lanlanhappy 2021/05/17 2:47 下午
 */
@ConditionalOnClass(value = {RequestInterceptor.class})
public class FeignTraceInterceptorConfig {

    @Resource
    private HappyLogProperties happyLogProperties;

    @Bean
    public RequestInterceptor feignTraceInterceptor() {
        return template -> {
            if (happyLogProperties.isEnableMdc()) {
                // 传递日志traceId
                String traceId = MDCTraceUtil.getTraceId();
                if (!StrUtil.isBlank(traceId)) {
                    template.header(MDCTraceUtil.TRACE_ID_HEADER, traceId);
                }
            }
        };
    }
}
