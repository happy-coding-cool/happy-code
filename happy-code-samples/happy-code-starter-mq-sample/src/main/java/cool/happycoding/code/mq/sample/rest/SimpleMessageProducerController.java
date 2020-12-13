package cool.happycoding.code.mq.sample.rest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.mq.sample.domain.Order;
import cool.happycoding.code.mq.sample.domain.OrderReply;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 11:43 上午
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("simple-producer")
public class SimpleMessageProducerController {

    private final RocketMQTemplate rocketMQTemplate;

    @PostMapping("sync-order")
    @ApiOperation(value = "普通消息-同步消息")
    public BaseResult<Order> syncOrder(@RequestBody Order order){
        order.setOrderDate(DateUtil.date());
        order.setOrderId(IdUtil.simpleUUID());
        rocketMQTemplate.convertAndSend("simple-topic:simple", order, message -> {
            log.info("headers:{}, message:{}", message.getHeaders(), message.getPayload().getClass());
            return message;
        });
        return BaseResult.success(order);
    }

    @PostMapping("async-order")
    @ApiOperation(value = "普通消息-异步消息")
    public BaseResult<Order> asyncOrder(@RequestBody Order order){
        order.setOrderDate(DateUtil.date());
        order.setOrderId(IdUtil.simpleUUID());
        rocketMQTemplate.asyncSend("simple-topic:simple", order, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("success:{}", sendResult);
            }
            @Override
            public void onException(Throwable e) {
                log.error("error message:{}", e.getMessage());
            }
        });
        return BaseResult.success(order);
    }

    @PostMapping("sync-order-reply")
    @ApiOperation(value = "普通消息-同步消息-携带返回值")
    public BaseResult<OrderReply> syncOrderReply(@RequestBody Order order){
        order.setOrderDate(DateUtil.date());
        order.setOrderId(IdUtil.simpleUUID());
        OrderReply orderReply = rocketMQTemplate.sendAndReceive("simple-topic:reply", order, OrderReply.class);
        return BaseResult.success(orderReply);
    }

    @PostMapping("one-way-order")
    @ApiOperation(value = "普通消息-单向消息")
    public BaseResult<Order> oneWayOrder(@RequestBody Order order){
        order.setOrderDate(DateUtil.date());
        order.setOrderId(IdUtil.simpleUUID());
        rocketMQTemplate.sendOneWay("simple-topic:simple",
                MessageBuilder.withPayload(order)
                .setHeader("one-way","单向消息")
                        .build());
        return BaseResult.success(order);
    }

}
