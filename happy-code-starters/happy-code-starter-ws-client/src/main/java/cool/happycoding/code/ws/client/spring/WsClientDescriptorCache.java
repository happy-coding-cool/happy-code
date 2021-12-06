package cool.happycoding.code.ws.client.spring;

import cn.hutool.core.util.ObjectUtil;

import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author lanlanhappy 2021/12/02 10:19 下午
 */
public abstract class WsClientDescriptorCache {

    private static final ConcurrentHashMap<String, WsClientDescriptor> WS_CLIENT_CACHE = new ConcurrentHashMap<>();


    static void put(Class<?> clientInterface){
        put(clientInterface.getName(), WsClientDescriptor.of(clientInterface));
    }

    static void put(String name, WsClientDescriptor wsClientDescriptor){
        if (ObjectUtil.isNotNull(wsClientDescriptor)){
            WS_CLIENT_CACHE.put(name, wsClientDescriptor);
        }
    }

    public static  WsClientDescriptor get(String name){
        return WS_CLIENT_CACHE.get(name);
    }


    public static void clean(){
        WS_CLIENT_CACHE.clear();
    }

}
