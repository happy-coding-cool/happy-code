package cool.happycoding.code.base.cache;

import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 11:17 上午
 */
public class LocalCache<K,V> implements Cache<K,V>{

    private final Map<K, CacheObject<K,V>> localCache;

    public LocalCache(int capacity){
        // 利用LinkedHashMap的特性实现LRU算法，避免出现OOM的问题
        this.localCache = new LRUMap<>(capacity);
    }

    public LocalCache(){
        // 利用LinkedHashMap的特性实现LRU算法，避免出现OOM的问题
        this.localCache = new LRUMap<>(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V val, long expire) {
        localCache.put(key, new CacheObject<>(key, val, expire));
    }

    @Override
    public V get(K key) {
        if (exists(key)){
            return null;
        }
        return localCache.get(key).getVal();
    }

    @Override
    public void remove(K key) {
        localCache.remove(key);
    }

    @Override
    public void clean() {
        localCache.clear();
    }

    @Override
    public boolean exists(K key) {
        CacheObject<K,V> valObj = localCache.get(key);
        return valObj.getVal() == null;
    }
}
