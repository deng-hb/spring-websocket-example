package com.denghb.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import java.util.Random;

@EnableWebSocketMessageBroker
@Controller
public class HelloWorldController {

    Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 一秒钟输出一个字符
     */
    @MessageMapping("/message")
    public void helloWorld(String value) {
        log.info("client:{}", value);
        String helloWorld = "Hello World";
        String[] strings = helloWorld.split("");

        for (String string : strings) {
            simpMessagingTemplate.convertAndSend("/topic/notice", string);
            try {
                Random random = new Random();
                Thread.currentThread().sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}