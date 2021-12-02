package cool.happycoding.code.ws.client.spring.proxy;

import cool.happycoding.code.ws.client.spring.WsClientDescriptor;
import cool.happycoding.code.ws.client.spring.WsClientDescriptorCache;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.lang.reflect.Proxy;

/**
 * description
 *
 * @author lanlanhappy 2021/12/02 1:09 下午
 */
public class WsClientProxyFactory <T>{

    private final Class<T> clientInterface;

    public WsClientProxyFactory(Class<T> clientInterface){
        this.clientInterface = clientInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance() {
        return (T)Proxy.newProxyInstance(this.clientInterface.getClassLoader(), new Class[]{this.clientInterface}, buildProxy());
    }

    private WsClientProxy buildProxy(){
        WsClientDescriptor descriptor = WsClientDescriptorCache.get(clientInterface.getName());
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(descriptor.getPathToPackage());
        WsClientProxy wsClientProxy = new WsClientProxy();
        wsClientProxy.setMarshaller(marshaller);
        wsClientProxy.setUnmarshaller(marshaller);
        wsClientProxy.setUrl(descriptor.getUrl());
        wsClientProxy.setAction(descriptor.getAction());
        return wsClientProxy;
    }

}
