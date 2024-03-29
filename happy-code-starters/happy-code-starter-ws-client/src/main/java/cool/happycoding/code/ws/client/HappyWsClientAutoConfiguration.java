package cool.happycoding.code.ws.client;

import cool.happycoding.code.ws.client.spring.WsClientDescriptorCache;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 3:12 下午
 */
@Configuration
public class HappyWsClientAutoConfiguration implements DisposableBean {


    @Override
    public void destroy(){
        WsClientDescriptorCache.clean();
    }
}
