package com.patrickalmeida.webfluxapi.api.v1;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import com.patrickalmeida.webfluxapi.domain.service.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Comparator;
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
        return playlistService.createPlaylist(playlist);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistsWithEventStream() {
        Flux<Long> intervalBetweenEvents = Flux.interval(Duration.ofSeconds(5));

        Flux<Playlist> playlists = playlistService.getAllPlaylists()
                .sort(Comparator.comparingInt(Playlist::getOrder));

        return Flux.zip(intervalBetweenEvents, playlists);
    }

}
