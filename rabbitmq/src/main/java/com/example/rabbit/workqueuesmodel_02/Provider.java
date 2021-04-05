package com.example.rabbit.workqueuesmodel_02;

import com.example.rabbit.util.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 第二种模型（work queues）工作模型
 * Work queues 也别称为（Task queues）任务模型。当消息处理比较消耗时，可能产生消息的速度会远远大于消息的消费速度。长此以往，消息会堆积
 * 越来越多，无法及时处理。此时就可以使用work模型：让多个消费者绑定到一个队列，共同消费队列中的消息。队列中的消息一旦消费，就会消失，
 * 因此任务是不会被重复执行的。
 * 默认情况下，RabbitMQ将按顺序将每个消息发送给下一个使用者。平均而言，每个消费者都会收到相同数量的消息。这种分发消息的方式称为循环。
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
        for (int i = 0 ; i < 20 ; i++) {
            channel.basicPublish("","aa", MessageProperties.PERSISTENT_TEXT_PLAIN,(i+" 你好啊").getBytes());
        }

        // 关闭通道
        channel.close();
        connection.close();
    }
}
