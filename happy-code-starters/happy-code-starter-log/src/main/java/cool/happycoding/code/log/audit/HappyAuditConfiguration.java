package cool.happycoding.code.log.audit;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author lanlanhappy 2021/04/20 9:36 下午
 */
@Configuration
public class HappyAuditConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HappyAuditRecorder happyAuditRecorder(){
        return new DefaultAuditRecorder();
    }

    @Bean
    @ConditionalOnClass({HttpServletRequest.class, RequestContextHolder.class})
    public HappyAuditAspect happyAuditAspect(HappyAuditRecorder happyAuditRecorder){
        return new HappyAuditAspect(happyAuditRecorder);
    }
}
