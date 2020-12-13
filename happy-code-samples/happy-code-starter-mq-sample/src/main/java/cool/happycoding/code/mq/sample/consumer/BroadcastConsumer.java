package cool.happycoding.code.mq.sample.consumer;

import cool.happycoding.code.mq.sample.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 11:52 上午
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic="broadcast-topic",
        consumerGroup = "broadcast-group",
        selectorType= SelectorType.TAG,
        selectorExpression="broadcast",
        messageModel= MessageModel.BROADCASTING)
public class BroadcastConsumer implements RocketMQListener<Order> {
    @Override
    public void onMessage(Order message) {
        log.info("order broadcast message:{}", message);
    }
}
