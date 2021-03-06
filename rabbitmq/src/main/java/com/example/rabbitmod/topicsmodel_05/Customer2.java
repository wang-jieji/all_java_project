package com.example.rabbitmod.topicsmodel_05;

import com.example.rabbitmod.util.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/6 1:29
 **/
public class Customer2 {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
       Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "topics";
        String exchangeType = "topic";
        // 通道绑定交换机
        channel.exchangeDeclare(exchangeName,exchangeType);
        // 获取一个临时的队列
        String queueName = channel.queueDeclare().getQueue();
        // 绑定交换机和队列
        channel.queueBind(queueName,exchangeName,"user.#");

        // 消费消息
        channel.basicConsume(queueName,false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2"+new String(body));
                // 手动确认  参数1：手动确认消息标识  参数2：是否开启多个消息同时确认 false：每次确认一个
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });


    }
}
