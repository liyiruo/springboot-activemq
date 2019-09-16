package com.example.springbootactivemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @JmsListener(destination = "mytest.queue")
    /**
     * 从上面的代码可以看出，我们在receiveQueue方法上面多加了
     * 一个注解@SendTo("out.queue")，该注解的意思是将return回的值，
     * 再发送的"out.queue"队列中
     */
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("Consumer2收到的报文为:"+text);
        return "return message"+text;
    }
}
