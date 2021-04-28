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
     * @param lockName  锁的名字
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit  时间粒度
     * @param fairLock  是否获取公平锁
     * @return HappyLock
     */
    HappyLock lock(String lockName, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock);

    /**
     * 获取分布式锁
     *
     * @param lockName 锁的名字
     * @return HappyLock
     */
    default HappyLock lock(String lockName){
        return lock(lockName, false);
    }

    /**
     * 获取分布式锁
     *
     * @param lockName 锁的名字
     * @param fairLock 是否获取公平锁
     * @return HappyLock
     */
    default HappyLock lock(String lockName, Boolean fairLock){
        return lock(lockName, -1, null, fairLock);
    }


    /**
     * 尝试获取分布式锁
     *
     * @param lockName 锁的名字
     * @return HappyLock
     */
    default HappyLock tryLock(String lockName){
        return tryLock(lockName, false);
    }

    /**
     * 尝试获取分布式锁
     *
     * @param lockName 锁的名字
     * @param fairLock 是否获取公平锁
     * @return HappyLock
     */
    HappyLock tryLock(String lockName, Boolean fairLock);

    /**
     * 尝试获取分布式锁
     *
     * @param lockName  锁的名字
     * @param waitTime  获取锁最长等待时间
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit  时间粒度
     * @param fairLock  是否获取公平锁
     * @return HappyLock
     */
    HappyLock tryLock(String lockName, Integer waitTime, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock);

    /**
     * 是否上锁
     *
     * @param lockName 锁的名字
     * @return HappyLock
     */
    HappyLock isLock(String lockName);

    /**
     * 关闭锁
     *
     * @param lock 锁的名字
     */
    void unlock(Object lock);

    /**
     * 释放锁
     * @param happyLock 锁抽象对象
     */
    default void unlock(HappyLock happyLock) {
        if (happyLock != null) {
            unlock(happyLock.getLock());
        }
    }
}
