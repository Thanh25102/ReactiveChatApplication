package com.example.reactivedemo.config;

import com.example.reactivedemo.functional.handler.WebSocketCustomHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import java.util.HashMap;

@Configuration
public class WebsocketConfig {

    @Bean
    public HandlerMapping handlerMapping() {
        var map = new HashMap<String, WebSocketHandler>();
        map.put("/path", new WebSocketCustomHandler());
        int order = -1; // before annotated controllers

        return new SimpleUrlHandlerMapping(map, order);
    }
}
