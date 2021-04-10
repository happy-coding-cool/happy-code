### happy-code-starter-swagger
#### 使用约定

已经引入了 happy-code-parent 父级依赖

#### 引入方式

- Maven

```
<dependency>
   <groupId>cool.happycoding</groupId>
   <artifactId>happy-code-starter-swagger</artifactId>
</dependency>
```    

- Gradle

```
compile 'cool.happycoding:happy-code-starter-swagger'
```

#### 说明
- 封装swagger配置
- 引入knife4j代替原生的swagger-ui

#### 配置项

    ## 是否启用swagger 默认true，即启用
    happy.code.swagger.enable
    ## 文档分组，默认spring.application.name
    happy.code.swagger.group
    ## 文档扫描路径
    happy.code.swagger.base-package
    ## 标题
    happy.code.swagger.title
    ## 描述
    happy.code.swagger.description
    ## 版本
    happy.code.swagger.version
    ## 服务地址
    happy.code.swagger.service-url
    ## 联系方式-url
    happy.code.swagger.contact.url
    ## 联系方式-name
    happy.code.swagger.contact.name
    ## 联系方式-email
    happy.code.swagger.contact.email

### 参考链接
- [knife4j](https://gitee.com/xiaoym/knife4j)