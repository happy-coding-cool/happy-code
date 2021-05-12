package cool.happycoding.code.log.audit;

import cool.happycoding.code.log.audit.async.HappyAuditLogEventListener;
import cool.happycoding.code.log.audit.async.HappyAuditLogEventPublisher;
import cool.happycoding.code.log.audit.async.SpringHappyAuditLogEventPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author lanlanhappy 2021/04/20 9:36 下午
 */
public class HappyAuditConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HappyAuditRecorder happyAuditRecorder(){
        return new DefaultAuditRecorder();
    }

    @Bean
    @ConditionalOnMissingBean
    public HappyAuditLogEventPublisher happyAuditLogEventPublisher(){
        return new SpringHappyAuditLogEventPublisher();
    }

    @Bean
    @ConditionalOnClass({HttpServletRequest.class, RequestContextHolder.class})
    public HappyAuditAspect happyAuditAspect(HappyAuditLogEventPublisher happyAuditLogEventPublisher){
        return new HappyAuditAspect(happyAuditLogEventPublisher);
    }

    @Bean
    public HappyAuditLogEventListener happyAuditLogListener(HappyAuditRecorder happyAuditRecorder){
        return new HappyAuditLogEventListener(happyAuditRecorder);
    }
}
