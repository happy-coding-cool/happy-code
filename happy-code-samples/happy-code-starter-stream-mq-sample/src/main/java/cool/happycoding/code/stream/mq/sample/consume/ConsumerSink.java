package cool.happycoding.code.stream.mq.sample.consume;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 8:53 下午
 */
public interface ConsumerSink {
    /**
     *
     * @return
     */
    @Input("input")
    SubscribableChannel input();
}
