package cool.happycoding.code.base.cache;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 11:15 上午
 */
public interface Cache<K,V>{
    /**
     * 默认容量
     */
    int DEFAULT_CAPACITY = 32;

    /**
     * 放入数据
     * @param key
     * @param val
     * @param expire
     */
    void put(K key, V val, long expire);

    /**
     * 放入数据，默认有效期为：10秒
     * @param key
     * @param val
     */
    default void put(K key, V val){
        put(key, val, 10 * 1000);
    }

    /**
     * 获取缓存值
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 删除缓存
     * @param key
     */
    void remove(K key);

    /**
     * 清空缓存
     */
    void clean();

    /**
     * key是否存在
     * @param key
     * @return
     */
    boolean exists(K key);
}