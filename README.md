# happy-code
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

本项目将日常开发中一些优秀实践封装起来，以微服务技术组件的形式赋能开发，致力于让代码变得简洁优雅，让开发变得简单高效，实现按时下班，回家吃饭的小目标！

## 如何使用
### 如何引入依赖
在pom.xml的配置中添加父级依赖
```
    <parent>
        <groupId>cool.happycoding</groupId>
        <artifactId>happy-code-parent</artifactId>
        <version>1.0.1.RELEASE</version>
    </parent>
```
然后在 `dependencies` 中添加自己所需使用的依赖即可使用
注意: 引入该parent之后，在添加happy-code,spring-boot,spring cloud,spring alibaba cloud 组件时均不需要再指定版本号

## 封装逻辑

## 模块介绍
- happy-code-base
- happy-code-dependencies
- happy-code-parent
- happy-code-starters
    - [happy-code-starter-log](happy-code-starters/happy-code-starter-log/README.md)
    - [happy-code-starter-mybatis](happy-code-starters/happy-code-starter-mybatis/README.md)
    - [happy-code-starter-user](happy-code-starters/happy-code-starter-user/README.md)
    - [happy-code-starter-swagger](happy-code-starters/happy-code-starter-swagger/README.md)
    - [happy-code-starter-validator](happy-code-starters/happy-code-starter-validator/README.md)
    - [happy-code-starter-web](happy-code-starters/happy-code-starter-web/README.md)
    - [happy-code-starter-cache](happy-code-starters/happy-code-starter-cache/README.md)
    - happy-code-starter-mq

## 版本更新记录
### 1.0.1.RELEASE
- feat: 引入jetcache完善cache组件
- feat: 完善mybatis组件引入乐观锁定义支持
- feat: 引入阿里ThreadLocal组件
- feat: 定义默认线程池(happyThreadPoolExecutor)，解决线程切换时上下文传递问题
- feat: web组件提供自定fastjson 序列化/反序列化配置扩展FastJsonConfigCustomizer
- feat: 完善log组件的功能提供mdc，请求耗时，请求参数/响应结果打印功能
- refactor: 更改组件依赖的继承体系，该改动会造成依赖不兼容的问题，按照新的配置方式进行调整即可
- refactor: 参照cola架构对异常和返回值封装进行优化
- fix: 修复cache组件组合注解的bug

### 1.0.0.RELEASE 
- feat: 初始版本
- feat: 规范依赖体系和版本
- feat: 封装web组件规定序列化/反序列化方式，封装前后端交互规范、全局异常处理规范
- feat: 封装validator组件，用于请求的入参校验
- feat: 封装swagger组件，用于接口文档的管理
- feat: 封装user组件，提供一个用于封装用户信息的UserContext
- feat: 封装mybatis组件，引入mybatis-plus，实现Entity对象规范定义
- feat: 封装log组件，规范log配置

## 框架选型
- spring Cloud Hoxton.SR8
- spring Cloud Alibaba 2.2.3.RELEASE

## 主要依赖
- lombok 1.18.12
- hutool 5.3.9
- fastjson 1.2.73
- guava 28.0-jre
- knife4j 3.0.2
- jetcache 2.6.0
- fastjson 1.2.75
- transmittable-thread-local 2.9.0

## 参考
- [Spring-Cloud-Alibaba版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)
- [transmittable-thread-local](https://github.com/alibaba/transmittable-thread-local)
- [knife4j](https://gitee.com/xiaoym/knife4j)
- [hutool](https://hutool.cn/)
- [mybatis](https://mybatis.org/mybatis-3/zh/index.html)
- [mybatis-plus](https://baomidou.com/guide/#%E7%89%B9%E6%80%A7)
- [jetcache](https://github.com/alibaba/jetcache/wiki/Home_CN)
- [COLA](https://github.com/alibaba/COLA)