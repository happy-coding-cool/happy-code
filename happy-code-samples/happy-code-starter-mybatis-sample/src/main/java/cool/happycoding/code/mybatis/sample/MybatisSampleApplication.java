package cool.happycoding.code.mybatis.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 12:01 下午
 */
@MapperScan("cool.happycoding.code.mybatis.sample.domain")
@SpringBootApplication
public class MybatisSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisSampleApplication.class, args);
    }
}
