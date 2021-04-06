package com.example.rabbitmod.publishsubscribemodel_03;

import com.example.rabbitmod.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Description 第三种模型(fanout) 广播
 * 在广播模式下，消息发送流程是这样的
 * 1、可以有多个消费者
 * 2、每个消费者有自己的queue（队列）
 * 3、每个队列都要绑定到Exchange（交换机）
 * 4、生产者发送的消息，只能发送到交换机，交换机来决定要发给哪个队列，生产者无法决定。
 * 5、交换机把消息发送给绑定过的所有队列
 * 6、队列的消费者都能拿到消息，实现一条消息被多个消费者消费
 * @Author WJJ
 * @Date 2021/4/6 0:29
 **/
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        // 获取连接中通道
        Channel channel = connection.createChannel();

        // 将通道声明指定交换机
        // 参数1：交换机名称（随意命名）,如果交换机不存在，会自动创建
        // 参数2：交换机类型  fanout 广播类型
        channel.exchangeDeclare("logs","fanout");
        // 参数1：交换机名称
        // 参数2：队列名称
        // 参数3：传递额外消息设置   MessageProperties.PERSISTENT_TEXT_PLAIN 消息持久化
        // 参数4: 消息的具体内容
        channel.basicPublish("logs","",null,"fanout type message".getBytes());
        // 关闭连接
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
