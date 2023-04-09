package com.patrickalmeida.webfluxapi.api.v1;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import com.patrickalmeida.webfluxapi.domain.service.PlaylistService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/playlists")
public class PlaylistResource {

    private final PlaylistService playlistService;

    public PlaylistResource(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping()
    public Flux<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public Mono<Playlist> getPlaylist(@PathVariable String id) {
        return playlistService.getPlaylistById(id);
    }

    @PostMapping()
    public Mono<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        playlist.setId(UUID.randomUUID().toString());
        return playlistService.createPlaylist(playlist);
    }

}
