package com.example.rabbit.routing_04;

import com.example.rabbit.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description 第四种模型（Routing）
 * 一、Routing之订阅模型-Direct(直连)
 * 在fanout模式中，一条消息，会被所有订阅的队列都消费，但是，在某些场景下，我们希望不同的消息被不同的队列消费。这时就要用到Direct类型的Exchang.
 * 在Direct模型下:
 * 1、队列与交换机的绑定，不能是任意绑定了，而是要指定一个 RoutingKey(路由key)
 * 2、消息的发送方 在向 Exchange发送消息时，也必须指定消息的RoutigKey。
 * 3、Exchange 不再把消息交给每一个绑定的队列，而是更加消息的 Routing Key进行判断，只有队列的RountingKey 与消息的 Routing key完全一致，才会接受到消息
 *
 * @Author WJJ
 * @Date 2021/4/6 1:50
 **/
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "direct_logs";
        String exchangeType = "direct";
        // 声明交换机
        channel.exchangeDeclare(exchangeName,exchangeType);
        // warning error info
        String routingKey = "info";
        channel.basicPublish(exchangeName,routingKey,null,("这是direct模型发布的基于route key: ["+routingKey+"] 发送的消息" ).getBytes(StandardCharsets.UTF_8));
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);


    }
}
