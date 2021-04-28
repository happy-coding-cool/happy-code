package cool.happycoding.code.lock;

import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author lanlanhappy 2021/04/28 7:54 下午
 */
public interface HappyDistributedLock {

    /**
     * 获取分布式锁
     *
     * @param key 锁的名字
     * @return Boolean
     */
    default Boolean lock(String key){
        return lock(key, false);
    }

    /**
     * 获取分布式锁
     *
     * @param key 锁的名字
     * @param fairLock 是否获取公平锁
     * @return Boolean
     */
    default Boolean lock(String key, Boolean fairLock){
        return lock(key, -1, null, fairLock);
    }

    /**
     * 获取分布式锁
     *
     * @param key  锁的名字
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit  时间粒度
     * @param fairLock  是否获取公平锁
     * @return Boolean
     */
    Boolean lock(String key, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock);

    /**
     * 尝试获取分布式锁
     *
     * @param key 锁的名字
     * @param waitTime 锁的名字
     * @param timeUnit 时间粒度
     * @return Boolean
     */
    default Boolean tryLock(String key, Integer waitTime, TimeUnit timeUnit){
        return tryLock(key, waitTime, timeUnit, false);
    }

    /**
     * 尝试获取分布式锁
     *
     * @param key 锁的名字
     * @param waitTime 锁的名字
     * @param timeUnit 时间粒度
     * @param fairLock 是否获取公平锁
     * @return Boolean
     */
    default Boolean tryLock(String key, Integer waitTime, TimeUnit timeUnit, Boolean fairLock){
        return tryLock(key, waitTime, -1, timeUnit, fairLock);
    }

    /**
     * 尝试获取分布式锁
     *
     * @param key  锁的名字
     * @param waitTime  获取锁最长等待时间
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit  时间粒度
     * @param fairLock  是否获取公平锁
     * @return Boolean
     */
    Boolean tryLock(String key, Integer waitTime, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock);

    /**
     * 是否上锁
     *
     * @param key 锁的名字
     * @return Boolean
     */
    Boolean isLock(String key);

    /**
     * 关闭锁
     *
     * @param key 锁的名字
     */
    void unlock(String key);
}
