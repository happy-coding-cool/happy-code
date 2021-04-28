package cool.happycoding.code.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description
 *
 * @author lanlanhappy 2021/04/28 7:59 下午
 */
@AllArgsConstructor
public class HappyLock implements AutoCloseable {

    @Getter
    private final Object lock;

    private final HappyDistributedLock locker;

    @Override
    public void close() throws Exception {
        locker.unlock(lock);
    }
}