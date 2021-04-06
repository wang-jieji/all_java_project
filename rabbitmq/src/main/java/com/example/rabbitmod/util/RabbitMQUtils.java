package com.example.rabbitmod.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQUtils {

    private static final String  HOST = "192.168.206.133";
    private static final int PORT = 5672 ;
    private static final String VIR_HOST = "/ems";
    private static final String USERNAME = "ems";
    private static final String PASSWORD = "ems";
    private static ConnectionFactory connectionFactory ;

    static {
        connectionFactory  = new com.rabbitmq.client.ConnectionFactory();
        // 设置连接rabbitmq主机
        connectionFactory.setHost(HOST);
        // 设置端口号
        connectionFactory.setPort(PORT);
        // 设置连接哪个虚拟机
        connectionFactory.setVirtualHost(VIR_HOST);
        // 设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername(USERNAME);
        connectionFactory.setPassword(PASSWORD);
    }

    public static Connection getConnection()  {
        try {
            // 获取连接对象
            Connection connection = connectionFactory.newConnection();
            return connection;
        }catch (Exception e){
           e.printStackTrace();
        }
        return null ;
    }

    public static void closeConnectionAndChanel(Channel channel , Connection connection) {
        try {
            if(channel != null) {
                channel.close();
            }
            if(connection != null) {
                connection.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
