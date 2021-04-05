package com.example.rabbit.workqueuesmodel_02;

import com.example.rabbit.util.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer2 {


    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();

        // 获取连接中通道
        Channel channel = connection.createChannel();
        // 每一次只能消费一个消息
        channel.basicQos(1);
        //通道绑定对应消息队列
        channel.queueDeclare("aa",true,false,true,null);
        // 消费消息
        // 参数1：消费哪个队列的消息  队列名称
        // 参数2：开始消息的自动确认机制  true: 消费者自动向rabbitmq确认消息消费   false 不自动确认消息
        // 参数3：消费时的回调接口
        channel.basicConsume("aa", false, new DefaultConsumer(channel) {
            // body : 消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("=========="+new String(body));
                // 手动确认  参数1：手动确认消息标识  参数2：是否开启多个消息同时确认 false：每次确认一个
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });


    }
}
