package cool.happycoding.code.lock;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author lanlanhappy 2021/04/28 7:54 下午
 */
@Slf4j
public class HappyRedissonDistributedLock implements HappyDistributedLock{

    private final RedissonClient redissonClient;

    public HappyRedissonDistributedLock(RedissonClient redissonClient){
        this.redissonClient = redissonClient;
    }


    @Override
    public HappyLock lock(String lockName) {
        return null;
    }

    @Override
    public HappyLock lock(String lockName, Boolean fairLock) {
        return null;
    }

    @Override
    public HappyLock lock(String lockName, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock) {
        return null;
    }

    @Override
    public HappyLock tryLock(String lockName) {
        return null;
    }

    @Override
    public HappyLock tryLock(String lockName, Boolean fairLock) {
        return null;
    }

    @Override
    public HappyLock tryLock(String lockName, Integer waitTime, Integer leaseTime, TimeUnit timeUnit, Boolean fairLock) {
        return null;
    }

    @Override
    public HappyLock isLock(String lockName) {
        return null;
    }

    @Override
    public void unlock(Object lock) {

    }
}
