package cool.happycoding.code.ws.client.annotation;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 3:14 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface WsClient {

    String url();

    String action();

    String[] pathToPackages();

}
