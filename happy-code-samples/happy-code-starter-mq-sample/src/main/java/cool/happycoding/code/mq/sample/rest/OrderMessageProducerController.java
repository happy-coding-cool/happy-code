package cool.happycoding.code.mq.sample.rest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.mq.sample.domain.Order;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 12:39 下午
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("order-producer")
public class OrderMessageProducerController {

    private final RocketMQTemplate rocketMQTemplate;

    @PostMapping("sync-order-message")
    @ApiOperation(value = "顺序消息-同步")
    public BaseResult<?> order(@RequestBody Order order){
        for (int i = 0; i < 7; i++) {
            order.setOrderDate(DateUtil.date());
            order.setOrderId(i+"");
            rocketMQTemplate.syncSendOrderly("order-topic:order", order, order.getOrderId());
        }
        return BaseResult.success();
    }
}
