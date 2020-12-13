package cool.happycoding.code.stream.mq.sample;

import cool.happycoding.code.stream.mq.sample.consume.ConsumerSink;
import cool.happycoding.code.stream.mq.sample.produce.ProducerResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 8:31 下午
 */
@SpringBootApplication
@EnableBinding({ ProducerResource.class, ConsumerSink.class})
public class StreamMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqApplication.class, args);
    }
}
