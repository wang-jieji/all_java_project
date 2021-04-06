package com.example.rabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // hello world
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world 直连");
    }

    // work queue
    @Test
    public void testWork(){
        for (int i = 1 ; i <= 20 ; i++) {
            rabbitTemplate.convertAndSend("work",i+" work 模型");
        }
    }

    // fanout 广播
    @Test
    public void testPublishsubScribe(){
        for (int i = 0 ; i < 20 ; i++) {
            rabbitTemplate.convertAndSend("logs",""," fanout 广播模型模型");
        }
    }

    // route 路由
    @Test
    public void testRoutingDirect(){
        for (int i = 0 ; i < 1 ; i++) {
            rabbitTemplate.convertAndSend("directs","warn","发送 info 的key 的路由信息");
        }
    }

    // topic 动态路由 订阅模式
    @Test
    public void testTopic(){
        for (int i = 0 ; i < 1 ; i++) {
            rabbitTemplate.convertAndSend("topics","a.order","user.save 的路由信息");
        }
    }

}