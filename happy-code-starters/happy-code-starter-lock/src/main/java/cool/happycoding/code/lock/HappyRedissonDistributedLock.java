package cool.happycoding.code.lock;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author lanlanhappy 2021/04/28 7:54 下午
 */
@Slf4j
public class HappyRedissonDistributedLock implements HappyDistributedLock{

    private final RedissonClient redisson;

    public HappyRedissonDistributedLock(RedissonClient redisson){
        this.redisson = redisson;
    }
    
    @Override
    public Boolean lock(String key, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock) {
        try {
            RLock lock = getLock(key, fairLock);
            lock.lock(leaseTime, timeUnit);
            log.debug("-------->[{}]获取到锁。", key);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("获取锁出现异常", e);
        }
        log.debug("-------->[{}]未获取到锁。", key);
        return Boolean.FALSE;
    }

    @Override
    public Boolean tryLock(String key, Integer waitTime, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock) {
        RLock lock = getLock(key, fairLock);
        try {
            boolean flag = lock.tryLock(waitTime, leaseTime, timeUnit);
            log.debug("-------->tryLock[{}] {}到锁。", key, flag ? "获取" : "未获取");
            return flag;
        } catch (Exception e) {
            log.error("尝试锁出现异常", e);
            return false;
        }
    }

    @Override
    public Boolean isLock(String key) {
        RLock lock = getLock(key, false);
        Boolean flag = lock.isLocked();
        log.debug("-------->检测到key[{}]" + (flag ? "已" : "未") + "上锁", key);
        return flag;
    }

    @Override
    public void unlock(String key) {
        RLock lock = getLock(key, false);
        if (ObjectUtil.isNotNull(lock) && isLock(key)) {
            log.debug("-------->[{}]解锁", key);
            lock.unlock();
        }
    }

    /**
     * 获取锁
     *
     * @param key 锁的名字
     * @param fairLock 是否获取公平锁
     * @return RLock
     */
    public RLock getLock(String key, Boolean fairLock) {
        return fairLock ? redisson.getFairLock(key) : redisson.getLock(key);
    }
}
