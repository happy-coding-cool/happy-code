package cool.happycoding.code.base.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2021/10/23 11:18 上午
 */
class LRUMap<K,V> extends LinkedHashMap<K,V> {

    /**
     * 默认最大容量 256
     */
    private static final int DEFAULT_MAX_CAPACITY = 256;
    /**
     * 默认初始容量 32
     */
    private static final int INITIAL_CAPACITY = 32;
    /**
     * 最大容量
     */
    private final int maxCapacity;

    public LRUMap(){
        this(INITIAL_CAPACITY, DEFAULT_MAX_CAPACITY);
    }

    public LRUMap(int capacity){
        this(INITIAL_CAPACITY, capacity);
    }

    public LRUMap(int initialCapacity, int maxCapacity){
        super(initialCapacity, 0.75f, true);
        this.maxCapacity = Math.max(initialCapacity, maxCapacity);
    }

    /**
     * 重写LinkedHashMap中removeEldestEntry方法;
     * 新增元素的时候,会判断当前map大小是否超过DEFAULT_MAX_CAPACITY,超过则移除map中最老的节点;
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxCapacity;
    }
}
