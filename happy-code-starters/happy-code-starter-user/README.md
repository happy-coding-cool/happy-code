### happy-code-starter-user
#### 使用约定

已经引入了 happy-code-dependencies 父级依赖

#### 引入方式

- Maven

```
<dependency>
   <groupId>cool.happycoding</groupId>
   <artifactId>happy-code-starter-user</artifactId>
</dependency>
```    

- Gradle

```
compile 'cool.happycoding:happy-code-starter-user'
```

#### 说明
> 此组件只是提供了一个可以使用UserContext上下文的封装

- 业务定义的User对象需要实现组件的User接口
- 用户信息上下文的Load需要请求Header参数中含有用户Id(默认取的参数名为:user-id,可配置)
- 由于组件是基于Filter(UserContextLoadFilter)实现的，因此如果应用中有自定义的Filter需要依赖UserContext的，请注意Filter的执行顺序问题（组件也提供了自身的order配置，以便调整执行顺序）
- UserContext是基于ThreadLocal实现的，因此在使用时应当特别注意发生线程上下文切换的情形

#### 使用方式
- 工具类：UserContextHolder.getUser()
- Controller参数注入： list(@CurrentUser DefaultUser user) 注：对象是User的子类即可

#### 配置项

    ## userId 默认值：-1
    happy.code.user.default-user-id
    ## userName 默认值：system
    happy.code.user.default-user-name
    ## 用户Id参数的字段名，默认：user-id
    happy.code.user.user-id-field
    ## UserContextLoadFilter的顺序，默认：1
    happy.code.user.filter-order