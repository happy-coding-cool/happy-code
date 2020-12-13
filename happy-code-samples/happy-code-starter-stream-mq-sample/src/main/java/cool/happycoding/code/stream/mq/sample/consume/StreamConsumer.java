package cool.happycoding.code.stream.mq.sample.consume;

import cool.happycoding.code.stream.mq.sample.UserBean;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 8:41 下午
 */
@Component
public class StreamConsumer {


    @StreamListener("input")
    public void receiveInput1(UserBean userBean) {
        System.out.println("input1 receive: " + userBean);
    }

    @StreamListener("input")
    public void receiveInput2(UserBean userBean) {
        System.out.println("input2 receive: " + userBean);
    }

}
