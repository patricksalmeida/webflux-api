package com.patrickalmeida.webfluxapi.api.v1.handler;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import com.patrickalmeida.webfluxapi.domain.service.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class PlaylistHandler {

    private final PlaylistService playlistService;

    public PlaylistHandler(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    public Mono<ServerResponse> getAllPlaylists(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.getAllPlaylists(), Playlist.class);
    }

    public Mono<ServerResponse> getPlaylist(ServerRequest request) {
        String playlistId = request.pathVariable("id");

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.getPlaylistById(playlistId), Playlist.class);
    }

    public Mono<ServerResponse> createPlaylist(ServerRequest request) {
        final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(playlistService::createPlaylist), Playlist.class));
    }

}
