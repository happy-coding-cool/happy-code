package cool.happycoding.code.ws.client.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * description
 *
 * @author lanlanhappy 2021/11/27 8:58 下午
 */
public class WsClientFactoryBean<T> implements FactoryBean<T> {

    private final Class<T> clientInterface;

    public WsClientFactoryBean(Class<T> clientInterface){
        this.clientInterface = clientInterface;
    }

    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return clientInterface;
    }
}
