package cool.happycoding.code.cache;

import com.alibaba.fastjson.JSON;
import com.alicp.jetcache.support.CacheMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2021/02/21 6:00 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SyncCacheMessage implements Serializable {

    private String area;
    private String cacheName;
    private String producerAddr;
    private long timestamp;
    private CacheMessage cacheMessage;


    public String toJSONString(){
        return JSON.toJSONString(this);
    }

    public static SyncCacheMessage syncCacheMessage(String jsonString){
        return JSON.parseObject(jsonString, SyncCacheMessage.class);
    }

}
