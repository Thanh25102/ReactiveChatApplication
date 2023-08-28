package com.example.reactivedemo.functional.router;

import com.example.reactivedemo.functional.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRouterConfig {
    public static final String USER_V1_URL = "/api/v1/users";
    public static final String USER_V1_ID_URL = "/api/v1/users/{id}";

    @Bean
    public RouterFunction<ServerResponse> userRouteV1(UserHandler handler) {
        return route()
                .GET(USER_V1_URL, accept(APPLICATION_JSON), handler::getAllUsers)
                .GET(USER_V1_ID_URL, accept(APPLICATION_JSON), handler::getUserById)
                .build();
    }

    ;
}
