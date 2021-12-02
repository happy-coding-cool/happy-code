package cool.happycoding.code.ws.client.spring.proxy;

import lombok.Setter;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author lanlanhappy 2021/12/02 1:09 下午
 */
@Setter
public class WsClientProxy extends WebServiceGatewaySupport implements InvocationHandler {

    private String url;
    private String action;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return this.getWebServiceTemplate().marshalSendAndReceive(url, args[0], new SoapActionCallback(action));
    }
}
