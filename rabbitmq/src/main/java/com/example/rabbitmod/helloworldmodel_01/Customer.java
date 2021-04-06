package com.example.rabbitmod.helloworldmodel_01;

import com.example.rabbitmod.util.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        // 获取连接中通道
        Channel channel = connection.createChannel();
        //通道绑定对应消息队列
        channel.queueDeclare("aa",true,false,true,null);
        // 消费消息
        // 参数1：消费哪个队列的消息  队列名称
        // 参数2：开始消息的自动确认机制
        // 参数3：消费时的回调接口
        channel.basicConsume("aa", true, new DefaultConsumer(channel) {
            // body : 消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("=========="+new String(body));
            }
        });


    }
}
