package com.example.reactivedemo.functional.handler;

import com.example.reactivedemo.domain.User;
import com.example.reactivedemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@Slf4j
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        Flux<User> userFlux = userService.findAll();
        return ok().body(userFlux, User.class);
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return userService.findById(id)
                .flatMap(user -> ok().bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }


}
