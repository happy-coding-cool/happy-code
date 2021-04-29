package cool.happycoding.code.lock;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *     自定义分布式锁注解
 *     被该注解注解的方法表示该方法已被加上分布式锁
 * </p>
 *
 * @author lanlanhappy 2021/04/29 4:33 下午
 */
public @interface HLock {

    /**
     * 锁的key
     *
     * 如果key可以确定，直接设置该属性，不写着默认格式为：类名(含包名全路径):方法名
     * 支持SpEL表达式，当key中包含#时则从参数中获取
     */
    String key() default "";

    /**
     * 是否使用公平锁。
     */
    boolean fairLock() default false;

    /**
     * 是否使用尝试锁。
     */
    boolean tryLock() default true;

    /**
     * 等待时间 超过则不在获取锁
     */
    int waitTime() default 0;

    /**
     * 过期时间
     */
    int leaseTime() default 30000;

    /**
     * 时间粒度(默认为毫秒)
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * 未获取到锁时 是否抛出异常
     */
    boolean throwException() default false;
}
