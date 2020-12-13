package cool.happycoding.code.mq.sample.rest;

import cool.happycoding.code.base.result.BaseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public BaseResult<?> order(){

        return BaseResult.success();
    }
}
