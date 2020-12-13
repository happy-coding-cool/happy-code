package cool.happycoding.code.mq.sample.consumer;

import cool.happycoding.code.mq.sample.domain.Order;
import cool.happycoding.code.mq.sample.domain.OrderReply;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 12:29 下午
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic="simple-topic",
        consumerGroup = "simple-group-reply",
        selectorType= SelectorType.TAG,
        selectorExpression="reply")
public class OrderReplyConsumer implements RocketMQReplyListener<Order, OrderReply> {

    @Override
    public OrderReply onMessage(Order message) {
        return new OrderReply(new Date(), message);
    }
}
