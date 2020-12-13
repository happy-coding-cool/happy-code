package cool.happycoding.code.stream.mq.sample.produce;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.stream.mq.sample.UserBean;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 8:37 下午
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("stream-producer")
public class ProducerController {

    private final ProducerResource producer;

    @PostMapping("output")
    @ApiOperation(value = "stream-output")
    public BaseResult<UserBean> output(@RequestBody UserBean userBean){
        userBean.setBirthday(DateUtil.date());
        userBean.setUserId(IdUtil.simpleUUID());
        userBean.setSalary(BigDecimal.valueOf(9527.22));
        producer.output().send(MessageBuilder.withPayload(userBean).build());
        return BaseResult.success(userBean);
    }


}
