package com.patrickalmeida.webfluxapi.api.v1.router;

import com.patrickalmeida.webfluxapi.api.v1.handler.PlaylistHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class PlaylistRouter {

//    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
        return RouterFunctions
                .route(GET("/api/v1/playlists").and(accept(MediaType.APPLICATION_JSON)), handler::getAllPlaylists)
                .andRoute(GET("/api/v1/playlists/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getPlaylist)
                .andRoute(POST("/api/v1/playlists").and(accept(MediaType.APPLICATION_JSON)), handler::createPlaylist);
    }

}
