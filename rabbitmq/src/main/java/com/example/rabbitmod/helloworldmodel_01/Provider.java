package com.example.rabbitmod.helloworldmodel_01;

import com.example.rabbitmod.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
/**
 * @Description 第一种模型（直连） Provider(P) : 生产者，也就是要发送消息的程序  Customer(C): 消费者：消息的接受者，会一直等待消息到来
 * http://192.168.206.133:15672 可以直接在web界面查看rabbitmq 默认账号 guest guest
 * @Author WJJ
 * @Date 2021/4/6 0:29
 **/
public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        // 获取连接中通道
        Channel channel = connection.createChannel();
        //通道绑定对应消息队列
        // 参数1：队列名称 如果队列不存在自动创建
        // 参数2：用来定义队列特性是否持久化   true 持久化队列（rabbitmq服务重启时将队列写入硬盘） false 不持久化（rabbitmq服务重启时删除队列）
        // 参数3：exclusive 是否独占队列      true 独占队列（这个队列只接受这个连接的消息）  false 不独占
        // 参数4：autoDelete: 是否在消息完成后自动删除队列  true 自动删除  false 不自动删除
        // 参数5：额外附加参数
        channel.queueDeclare("aa",true,false,true,null);

        // 发布消息
        // 参数1：交换机名称
        // 参数2：队列名称
        // 参数3：传递额外消息设置   MessageProperties.PERSISTENT_TEXT_PLAIN 消息持久化
        // 参数4: 消息的具体内容
        channel.basicPublish("","aa", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello Customer".getBytes());

        // 关闭通道
        channel.close();
        connection.close();
    }
}
