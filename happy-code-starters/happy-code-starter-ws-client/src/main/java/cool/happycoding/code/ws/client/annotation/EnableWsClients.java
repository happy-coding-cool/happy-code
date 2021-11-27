package cool.happycoding.code.ws.client.annotation;

import cool.happycoding.code.ws.client.spring.WsClientsRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 3:14 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(WsClientsRegistrar.class)
public @interface EnableWsClients {
    String[] basePackages() default {};
}
