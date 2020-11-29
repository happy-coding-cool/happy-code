# happy-code
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

本项目将日常开发中一些优秀实践封装起来，以微服务技术组件的形式赋能开发，致力于让代码变得简洁优雅，让开发变得简单高效，实现按时下班，回家吃饭的小目标！

## 如何使用
### 如何引入依赖
如果需要使用已发布的版本，在 `dependencyManagement` 中添加如下配置。

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-dependencies</artifactId>
            <version>1.0.0.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

然后在 `dependencies` 中添加自己所需使用的依赖即可使用。


## 模块介绍
- happy-code-base
```
1. 基础类定义
2. 基础业务异常定义
```
- happy-code-dependencies


## 版本更新记录
### V1.0.0 
- 初始版本
- 规范依赖体系和版本

## 框架选型
- spring Cloud Hoxton.SR8
- spring Cloud Alibaba 2.2.3.RELEASE

## 主要依赖
- lombok 1.18.12
- hutool 5.3.9
- fastjson 1.2.73
- guava 28.0-jre
- knife4j 2.0.5

## 参考
- [Spring-Cloud-Alibaba版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)
- [Swagger-bootstrap-ui](https://github.com/xiaoymin/swagger-bootstrap-ui/blob/master/README_zh.md)