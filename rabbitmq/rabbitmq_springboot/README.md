springboot 整合 rabbitmq

springboot 提供了一个模板类 RabbitTemplate 用来简化操作，使用的时候直接在项目中注入即可

MQ的应用场景
1、异步处理
场景说明：用户注册后，需要发注册邮件和注册短信，传统的做法有两种