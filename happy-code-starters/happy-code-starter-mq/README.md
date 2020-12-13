### happy-code-starter-mq
#### 使用约定

已经引入了 happy-code-dependencies 父级依赖

#### 引入方式

- Maven

```
<dependency>
   <groupId>cool.happycoding</groupId>
   <artifactId>happy-code-starter-mq</artifactId>
</dependency>
```    

- Gradle

```
compile 'cool.happycoding:happy-code-starter-mq'
```

#### 说明
- 引入rocketmq的官方starter(org.apache.rocketmq:rocketmq-spring-boot-starter)

#### 使用
- 普通消息三种发送方式：同步，异步，单向(参考sample工程:SimpleMessageProducerController)
- 收发顺序消息
- 订阅消息集群,广播
- 收发事务消息
- 收发延迟消息
- 收发定时消息
    
### 参考链接
- [rocketmq-spring](https://github.com/apache/rocketmq-spring)