package com.example.rabbitmod.topicsmodel_05;

import com.example.rabbitmod.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description 第五种模型（Topic）
 * 一、Routing之订阅模型-Topic
 * Topic 类型的Exchange 与 Direct 相比，都是可以根据 RountingKey 把消息路由到不同的队列。只不过 Topic类型Exchange 可以让
 * 队列绑定 RoutingKey 的时候使用通配符！ 这种模型 RoutingKey一般都由一个或多个单词组成，多个单词之间以"." 分割，例如 item.insert
 * 通配符：
 * 1、 * (star)  匹配不多不少恰好1个词
 * 2、 #（hash） 匹配一个或多个
 * 例如
 *  audit.*  只能匹配 audit.irs
 *  audit.#  匹配audit.irs.corporate 或者 audit.irs 等
 * @Author WJJ
 * @Date 2021/4/6 1:50
 **/
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "topics";
        String exchangeType = "topic";
        // 声明交换机
        channel.exchangeDeclare(exchangeName,exchangeType);
        // warning error info
        String routingKey = "user.insert.delete";
        channel.basicPublish(exchangeName,routingKey,null,("这里是topic动态路由模型，route key: ["+routingKey+"] 发送的消息" ).getBytes(StandardCharsets.UTF_8));
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);


    }
}
