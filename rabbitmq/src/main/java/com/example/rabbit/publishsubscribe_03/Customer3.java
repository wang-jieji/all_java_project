package com.example.rabbit.publishsubscribe_03;

import com.example.rabbit.util.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/6 1:29
 **/
public class Customer3 {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
       Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        // 通道绑定交换机
        channel.exchangeDeclare("logs","fanout");
        // 获取一个临时的队列
        String queueName = channel.queueDeclare().getQueue();
        // 绑定交换机和队列
        channel.queueBind(queueName,"logs","");

        // 消费消息
        channel.basicConsume(queueName,false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("=========="+new String(body));
                // 手动确认  参数1：手动确认消息标识  参数2：是否开启多个消息同时确认 false：每次确认一个
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });


    }
}
