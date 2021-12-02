package cool.happycoding.code.ws.client.spring;

import cn.hutool.core.util.ObjectUtil;
import cool.happycoding.code.ws.client.SoapVersion;
import cool.happycoding.code.ws.client.annotation.WsClient;
import lombok.Builder;
import lombok.Data;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * description
 *
 * @author lanlanhappy 2021/12/02 9:54 下午
 */
@Data
@Builder
public class WsClientDescriptor {
    
    private Class<?> clientInterface;
    private String url;
    private String action;
    private String[] pathToPackage;
    private SoapVersion soapVersion;
    private Class<?> fallbackFactory;
    
    public static WsClientDescriptor of(Class<?> clientInterface){
        WsClient wsClient = AnnotationUtils.findAnnotation(clientInterface, WsClient.class);
        if (ObjectUtil.isNotNull(wsClient)){
            return WsClientDescriptor.builder()
                    .url(wsClient.url())
                    .action(wsClient.action())
                    .pathToPackage(wsClient.pathToPackages())
                    .soapVersion(wsClient.soapVersion())
                    .fallbackFactory(wsClient.fallbackFactory())
                    .clientInterface(clientInterface)
                    .build();
        }
        return null;
    }
}
