package com.example.reactivedemo.functional.handler;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebSocketCustomHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> output = session.receive()
                .doOnNext(message -> {
                    //...
                })
                .concatMap(message -> {
                    //...
                    return null;
                })
                .map(value -> session.textMessage("Echo " + value));
        return session.send(output);
    }
}
