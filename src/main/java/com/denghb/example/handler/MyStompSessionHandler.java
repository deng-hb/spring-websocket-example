package com.denghb.example.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;

/**
 * Created by ppd on 2017/4/24.
 */
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    Logger log = LoggerFactory.getLogger(MyStompSessionHandler.class);

    @Override
    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
        log.info("afterConnected");
    }

    @Override
    public void handleException(StompSession stompSession, StompCommand stompCommand, StompHeaders stompHeaders, byte[] bytes, Throwable throwable) {
        log.info("handleException");

    }

    @Override
    public void handleTransportError(StompSession stompSession, Throwable throwable) {
        log.info("handleTransportError");

    }

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return null;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        log.info("handleFrame");

    }
}
