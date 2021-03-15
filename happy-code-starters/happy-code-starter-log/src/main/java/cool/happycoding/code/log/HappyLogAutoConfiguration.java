package cool.happycoding.code.log;

import org.springframework.context.annotation.Configuration;

/**
 * description
 * TRACE < DEBUG < INFO <  WARN < ERROR
 * 日志级别越低意味着打印的日志量越大，如：
 * 设置为：
 *  TRACE时，级别为：TRACE、DEBUG、INFO、WARN、ERROR 会被打印
 *  DEBUG时，级别为：DEBUG、INFO、WARN、ERROR 会被打印
 *  INFO时，级别为：INFO、WARN、ERROR 会被打印
 *  WARN时，级别为：WARN、ERROR 会被打印
 *  ERROR时，级别为：ERROR 会被打印
 * @author lanlanhappy 2020/12/06 11:33 上午
 */
@Configuration
public class HappyLogAutoConfiguration {
}
