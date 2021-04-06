package com.example.rabbitmq.helloworldmodel;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/6 3:18
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "true"))
public class HelloCustomer {

    @RabbitHandler
    public void receivel(String message) {
        System.out.println("message = " + message);
    }
}
