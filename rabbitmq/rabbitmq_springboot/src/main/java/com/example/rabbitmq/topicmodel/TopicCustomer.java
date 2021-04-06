package com.example.rabbitmq.topicmodel;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/6 10:51
 **/
@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topics",type = "topic"),
                    key = {"user.save","user.*"}
            )
    })
    public void receivel(String message) {
        System.out.println("message1="+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topics",type = "topic"),
                    key = {"*.order.#","produce.#","user.*"}
            )
    })
    public void receivel2(String message) {
        System.out.println("message2="+message);
    }
}
