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

注：由于返回的结果类型可能无法打印，因此组件只是提供了对返回类型为json的结果
 
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
无
  