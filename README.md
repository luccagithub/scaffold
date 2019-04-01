# 脚手架

### 强制要求

#### 包名需要一致格式

#### 3层结构对象

- 项目分为3层``controller``,``service``,``dao``。``dao``操作对象有``model``,``PO``。``service``操作对象有``dto``,``BO``。``controller``操作对象有``RO``,``VO``.
- 层级从上到下,不能下层调用上层对象.``service``不能直接用mapper对象做操作,应该经过``dao``操作持久层.
- 原则必须有``model``,``DTO``,``VO``,其他对象视逻辑复杂度决定是否需要

#### 其他使用规范请参照脚手架的例子

### 使用指南

1. 新建项目需要遵守脚手架的文件目录结构和包名规范
2. 引用基础包只需要添加对应的starter即可,可选择有:
```
zfax-starter-web 跟Web相关的项目
zfax-starter-dubbo 需要Dubbo的项目
zfax-starter-mybatis 需要操作数据库的项目
zfax-starter-config 需要使用配置中心的项目
zfax-starter-event 需要发送MQ事件的项目
zfax-starter-job 需要使用定时任务的项目 
zfax-starter-redis 需要使用Redis的项目
zfax-starter-mongo 需要使用MongoDB的项目
```

#### zfax-starter-web
1. 制定了标准Rest返回结果
2. 制定了标准异常处理

- **业务异常**是指不满足业务逻辑,且需要返回一些提示信息给前端。我们统一通过异常传递的方式将信息返回给前端。避免了传统方式依靠方法调用结果的判断来组装返回结果，减少冗余代码，简化代码判断逻辑。
- 使用例子:
```java
// 业务异常直接抛出BusinessException,msgKey 对应message.properties里面的配置
throw new BusinessException("msgKey");
```
- 自定义业务异常需要继承BusinessException.默认业务异常Http状态为412.如果想自定义http状态码在异常类上添加注解@ResponseStatus

3. 获取登录用户信息,在``Controller``的方法上注入``Subject``对象,可以获得当前登录用户信息
4. 集成swagger文档,可配置swagger标题:

```
swagger.api.title 标题
swagger.api.version 版本
```
5. 提供便利检验注解

```java
@ChineseName, @ChineseOnly, @Cnid, @Email, @IdNotNull, @Mobile, @QQ, @Telephone
```
6. 配置
```properties
server.port=8081
spring.application.name=scaffold
eureka.client.serviceUrl.defaultZone=http://172.31.9.150:11001/eureka/,http://172.31.9.150:11002/eureka/
server.error.include-stacktrace=never #always可以返回错误的信息,on_trace_param传递trace=true参数可以返回错误信息,never可以屏蔽错误信息(生产环境)
```
7. 提供密码加密工具``BCryptPasswordEncoder``,使用Bean注入即可

#### zfax-starter-dubbo
1. 使用提供的注解``@Provider``代表提供服务,``@Reference``代表消费服务
2. 配置
```properties
spring.dubbo.registry.address=192.168.9.170:2181
spring.dubbo.protocol.port=52001
```

#### zfax-starter-mybatis
1. 使用mybatis-plus,具体API可以看[官方文档](http://mp.baomidou.com/#/?id=%E7%AE%80%E4%BB%8B)
2. 配置
```properties
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:mysql://192.168.9.172:3306/user
```

#### zfax-starter-config 
1. 连接阿波罗配置,需要启动命令
```-Denv=DEV -Dapollo.cluster=DEV -Dapollo.namespace=application,TEST1.global -Ddev_meta=http://172.31.9.199:8080```
2. [官方文档](https://github.com/ctripcorp/apollo/wiki/Apollo%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83%E4%BB%8B%E7%BB%8D)

#### zfax-starter-job
1. 定时任务需要在类上面添加注解``@SimpleJobComponent``,并且继承SimpleJob
2. [官方文档](http://elasticjob.io/docs/elastic-job-lite/00-overview)
3. 配置
```properties
job.registry.address=192.168.9.170:2181
```

#### zfax-starter-event
1. 在事件处理类上添加``@EventListener(classes = EndFlowEvent.class)``就可以监听到关注的事件类型
2. 发送消息接口``EventPublisher``可以直接使用这个Bean
3. 配置
```properties
event.publisher.enable=true 
event.listener.enable=true
event.uri=amqp://risk:risk@192.168.9.101:5671/zfax-risk
event.listener.queue=scaffold-refactor.queue
```

#### zfax-starter-redis
1. 需要使用Spring提供的``RedisTemplate``

#### zfax-starter-mongo
1. 需要使用Spring提供的``MongoTemplate``
2. 配置
```properties
spring.data.mongodb.host=172.31.9.135
spring.data.mongodb.database=judex
spring.data.mongodb.port=27017
spring.data.mongodb.username=judex
spring.data.mongodb.password=judex
```

#### 添加基本单元测试
目的为了CI执行可以检查应用是否可以正常启动,添加基本的容器启动单元测试
```JAVA
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
public class ScaffoldApplicationTest {

    @Test
    public void contextLoad() {

    }
}
```
添加配置文件,防止dubbo端口冲突
```properties
spring.dubbo.protocol.port=${random.int(50000,70000)}
```
#### IDEA设置
1. 配置编码转换,适应properties的中文配置.在设置中勾选``Editor->File Encodings-> transparent native-to-ascii conversion``
2. 安装lombok插件
3. 导入code-quality项目里面的代码格式化文件
