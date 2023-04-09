package com.patrickalmeida.webfluxapi.domain.service;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> getAllPlaylists();
    Mono<Playlist> getPlaylistById(String id);
    Mono<Playlist> createPlaylist(Playlist playlist);

}
