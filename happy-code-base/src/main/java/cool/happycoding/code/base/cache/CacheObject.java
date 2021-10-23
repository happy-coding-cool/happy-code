package cool.happycoding.code.base.cache;

import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 11:16 上午
 */
class CacheObject<K, V> implements Serializable {

    private K key;
    private V val;
    private long expire;

    public CacheObject(K key, V val, long expire){
        this.key = key;
        this.val = val;
        this.expire = System.currentTimeMillis() + expire;
    }

    public V getVal() {
        if (System.currentTimeMillis() > expire){
            return null;
        }
        return val;
    }

}