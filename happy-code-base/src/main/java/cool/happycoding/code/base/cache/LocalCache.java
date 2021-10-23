package cool.happycoding.code.base.cache;

import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 11:17 上午
 */
public class LocalCache<K,V> implements Cache<K,V>{

    private final Map<K, CacheObject<K,V>> cache;
    private final StampedLock lock = new StampedLock();

    public LocalCache(){
        this(DEFAULT_CAPACITY);
    }

    public LocalCache(int capacity){
        this.cache = new LRUMap<>(capacity);
    }

    @Override
    public void put(K key, V val, long expire) {
        final long stamp = lock.writeLock();
        try {
            putWithoutLock(key, val, expire);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    private void putWithoutLock(K key, V object, long expire) {
        cache.put(key, new CacheObject<>(key, object, expire));
    }

    @Override
    public V get(K key) {
        if (exists(key)){
            return null;
        }
        return cache.get(key).getVal();
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void clean() {
        cache.clear();
    }

    @Override
    public boolean exists(K key) {
        CacheObject<K,V> valObj = cache.get(key);
        return valObj.getVal() == null;
    }
}
