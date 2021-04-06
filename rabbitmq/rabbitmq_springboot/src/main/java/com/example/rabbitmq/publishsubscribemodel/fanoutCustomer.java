package com.example.rabbitmq.publishsubscribemodel;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description fanout 广播模型
 * @Author WJJ
 * @Date 2021/4/6 10:16
 **/
@Component
public class fanoutCustomer {

    // 第一个消费者
    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue, // 创建临时队列
            exchange = @Exchange(value = "logs",type = "fanout")    // 绑定的交换机

    )})
    public void receivel(String message){
        System.out.println("message1 =" + message);
    }

    // 第二个消费者
    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue, // 创建临时队列
            exchange = @Exchange(value = "logs",type = "fanout")    // 绑定的交换机

    )})
    public void receivel2(String message){
        System.out.println("message2 =" + message);
    }
}
