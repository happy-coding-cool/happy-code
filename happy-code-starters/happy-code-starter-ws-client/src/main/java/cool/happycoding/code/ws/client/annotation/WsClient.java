package cool.happycoding.code.ws.client.annotation;

import cool.happycoding.code.ws.client.SoapVersion;

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

    /**
     * url
     * @return url
     */
    String url();

    /**
     * action
     * @return action url
     */
    String action();

    /**
     * @return return the packages to search for JAXB2 annotations
     */
    String[] pathToPackages();

    /**
     * soap version default soap 1.1
     * @return soap version
     */
    SoapVersion soapVersion() default SoapVersion.SOAP_11;

    /**
     * @return fallback config
     */
    Class<?> fallbackFactory() default void.class;


}
