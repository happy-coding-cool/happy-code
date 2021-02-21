package cool.happycoding.code.cache;

import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.autoconfigure.JetCacheAutoConfiguration;
import com.alicp.jetcache.support.CacheMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * description
 *
 * @author lanlanhappy 2021/02/21 11:31 上午
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(HappyCacheProperties.class)
@PropertySource({"classpath:happy-jetcache.properties"})
@AutoConfigureBefore({JetCacheAutoConfiguration.class})
public class HappyCacheAutoConfiguration {

    private final HappyCacheProperties happyCacheProperties;
    private final StringRedisTemplate stringRedisTemplate;
    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    public CacheMessagePublisher cacheMessagePublisher(){
        return new SyncRedisCacheMessagePublisher(happyCacheProperties, stringRedisTemplate);
    }

    @Bean
    @ConditionalOnMissingBean
    public SyncCachePostProcessor syncCachePostProcessor(){
        return new NoneSyncCachePostProcessor();
    }

    @Bean
    public ChannelTopic channelTopic(){
        return new ChannelTopic(happyCacheProperties.getBothCacheSyncTopic());
    }

    @Bean
    @SuppressWarnings("all")
    public RedisMessageListenerContainer redisMessageListenerContainer(SpringConfigProvider springConfigProvider,
                                                                       SyncCachePostProcessor syncCachePostProcessor){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(
                new SyncRedisCacheMessageListener(springConfigProvider,
                        syncCachePostProcessor, stringRedisTemplate),
                channelTopic());
        return redisMessageListenerContainer;
    }
}
