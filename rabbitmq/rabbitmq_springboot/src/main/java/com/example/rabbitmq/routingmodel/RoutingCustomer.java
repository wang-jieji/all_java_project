package com.example.rabbitmq.routingmodel;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/6 10:40
 **/
@Component
public class RoutingCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时交换即
                    exchange = @Exchange(value = "directs",type = "direct"), // 指定交换机名称和类型
                    key = {"info","error","warn"}
            )
    })
    private void receivel(String message) {
        System.out.println("message1"+ message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时交换即
                    exchange = @Exchange(value = "directs",type = "direct"), // 指定交换机名称和类型
                    key = {"error"}
            )
    })
    private void receivel2(String message) {
        System.out.println("message2"+ message);
    }

}
