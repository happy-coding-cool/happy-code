### happy-code-starter-validator
#### 使用约定

已经引入了 happy-code-dependencies 父级依赖

#### 引入方式

- Maven

```
<dependency>
   <groupId>cool.happycoding</groupId>
   <artifactId>happy-code-starter-validator</artifactId>
</dependency>
```    

- Gradle

```
compile 'cool.happycoding:happy-code-starter-validator'
```

#### 说明
> 校验组件集成了 Hibernate Validator(支持JSR303–Bean Validation规范) 并在此基础上扩展了部分常用的校验

##### Bean Validation 中内置的 校验

| Constraint | 详细信息 |
|------------|--------|
|@Null	|被注释的元素必须为 null|
|@NotNull	|被注释的元素必须不为 null|
|@AssertTrue	|被注释的元素必须为 true|
|@AssertFalse	|被注释的元素必须为 false|
|@Min(value)	|被注释的元素必须是一个数字，其值必须大于等于指定的最小值|
|@Max(value)	|被注释的元素必须是一个数字，其值必须小于等于指定的最大值|
|@DecimalMin(value)	|被注释的元素必须是一个数字，其值必须大于等于指定的最小值|
|@DecimalMax(value)	|被注释的元素必须是一个数字，其值必须小于等于指定的最大值|
|@Size(max, min)	|被注释的元素的大小必须在指定的范围内|
|@Digits (integer, fraction)	|被注释的元素必须是一个数字，其值必须在可接受的范围内|
|@Past	|被注释的元素必须是一个过去的日期|
|@Future	|被注释的元素必须是一个将来的日期|
|@Pattern(value)	|被注释的元素必须符合指定的正则表达式|

##### Hibernate Validator 扩展的校验

| Constraint | 详细信息 |
|------------|--------|
|@Email	|被注释的元素必须是电子邮箱地址|
|@Length	|被注释的字符串的大小必须在指定的范围内|
|@NotEmpty	|被注释的字符串的必须非空|
|@Range	|被注释的元素必须在合适的范围内|

##### 组件扩展的校验

| Constraint | 详细信息 |
|------------|--------|
| @Birthday | 生日校验 |
| @Cellphone | 验证是否为手机号码（中国）|
| @Chinese | 中文校验 |
| @English | 英文校验 | 
| @IdCard | 验证是否为身份证号码（18位中国）|
| @PlateNumber | 验证是否为中国车牌号 |


#### 配置项
    ## 此配置等同于: hibernate.validator.fail_fast
    ## 快速失败模式(即：当有多个校验规则时为true时，有一个不满足立即结束校验，false：则会校验完所有规则)
    ## 默认: false
    happy.code.validator.fail-fast
        
### 参考资料
- [JSR 303 – Bean Validation 介绍及最佳实践](https://developer.ibm.com/zh/articles/j-lo-jsr303/)
   
 


