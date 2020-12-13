package cool.happycoding.code.mq.sample.rest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.mq.sample.domain.Order;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *     事务消息
 * </p>
 *
 * @author lanlanhappy 2020/12/13 3:14 下午
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("transaction-producer")
public class TransactionMessageProducerController {

    private final RocketMQTemplate rocketMQTemplate;

    @PostMapping("transaction-order")
    @ApiOperation(value = "事务消息")
    public BaseResult<?> transactionOrder(@RequestBody Order order){
        order.setOrderDate(DateUtil.date());
        order.setOrderId(IdUtil.simpleUUID());
        rocketMQTemplate.sendMessageInTransaction("transaction-topic:tx",
                MessageBuilder
                        .withPayload(order)
                        .build(),
                order.getOrderId());
        return BaseResult.success(order);
    }
}
