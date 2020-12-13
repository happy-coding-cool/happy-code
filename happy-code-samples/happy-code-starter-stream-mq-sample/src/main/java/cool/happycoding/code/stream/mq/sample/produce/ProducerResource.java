package cool.happycoding.code.stream.mq.sample.produce;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 8:42 下午
 */
public interface ProducerResource {

    /**
     * 发送消息
     * @return
     */
    @Output("output")
    MessageChannel output();
}
