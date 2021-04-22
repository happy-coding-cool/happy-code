## log组件
#### 使用约定

已经引入了 happy-code-parent 父级依赖

#### 引入方式

- Maven

```
<dependency>
   <groupId>cool.happycoding</groupId>
   <artifactId>happy-code-starter-log</artifactId>
</dependency>
```    

- Gradle

```
compile 'cool.happycoding:happy-code-starter-log'
```

#### 说明

- 提供了打印请求响应时间间隔特性
- 提供MDC设置特性
- 提供打印请求/响应数据的特性
- 日志级别说明
```
    TRACE < DEBUG < INFO <  WARN < ERROR
    日志级别越低意味着打印的日志量越大，如：
    设置为：
        TRACE时，级别为：TRACE、DEBUG、INFO、WARN、ERROR 会被打印
        DEBUG时，级别为：DEBUG、INFO、WARN、ERROR 会被打印
        INFO时，级别为：INFO、WARN、ERROR 会被打印
        WARN时，级别为：WARN、ERROR 会被打印
        ERROR时，级别为：ERROR 会被打印
```


注：由于返回的结果类型可能无法打印，因此组件只是提供了对返回类型为json的结果

#### 扩展
- 提供了操作审计功能
- 应用可以通过实现 MdcParamCollector 接口将需要的参数放入MDC
- 组件提供来默认实现，放入trace-id
注：放入MDC的参数，可以通过日志配置进行打印，以trace-id为例，格式为：```[%{trace-id}]```

#### 启用审计功能
- 在启动类上添加@EnableHappyAudit注解启用该功能
- 在需要记录的操作上方法上标记@HappyAudit 注解
- 如果需要持久化审计日志，则需要实现HappyAuditRecorder接口，组件提供了默认的实现(仅做日志打印)

#### 配置项
```
    ## 是否启用mdc 特性，默认：启用，true
    happy.code.log.enable-mdc
    ## 是否启用打印请求耗时，默认：启用，true
    happy.code.log.enable-exe-time

    ## 是否打印请求header，默认：关闭，false
    happy.code.log.enable-print-header
    ## 是否打印请求参数，默认：关闭，false
    happy.code.log.enable-print-request
    ## 是否打印响应结果，默认：关闭，false
    happy.code.log.enable-print-response
    ## 启用以上三个属性时，需要忽略打印的请求url
    happy.code.log.excludes
```   

    
#### 参考资料
- [Slf4j-MDC](http://logback.qos.ch/manual/mdc.html)
  