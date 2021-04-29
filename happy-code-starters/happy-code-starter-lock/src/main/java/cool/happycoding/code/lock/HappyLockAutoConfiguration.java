package cool.happycoding.code.lock;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author lanlanhappy 2021/04/28 7:40 下午
 */
@Configuration
@RequiredArgsConstructor
@ConditionalOnClass({Redisson.class, RedissonClient.class})
@AutoConfigureAfter(RedissonAutoConfiguration.class)
public class HappyLockAutoConfiguration {

    private final RedissonClient redisson;

    @Bean
    public HappyDistributedLock distributedLock() {
        return new HappyRedissonDistributedLock(redisson);
    }

    @Bean
    public HappyDistributedLockAspect happyDistributedLockAspect(){
        return new HappyDistributedLockAspect(distributedLock());
    }
}
