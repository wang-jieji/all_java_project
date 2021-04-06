package com.example.rabbitmq.workqueuemodel;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description work queue 工作模型
 * @Author WJJ
 * @Date 2021/4/6 9:54
 **/
@Component
public class WorkCustomer {
    // 第一个消费者
    @RabbitListener(queuesToDeclare = @Queue(value = "work",autoDelete = "true"))
    public void receivel(String message){
        System.out.println("message1="+message);
    }

    // 第二个消费者
    @RabbitListener(queuesToDeclare = @Queue(value = "work",autoDelete = "true"))
    public void receivel2(String message){
        System.out.println("message2="+message);
    }
}
