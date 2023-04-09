package com.patrickalmeida.webfluxapi.domain.service;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import com.patrickalmeida.webfluxapi.domain.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Flux<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> getPlaylistById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> createPlaylist(Playlist playlist) {
        playlist.setId(UUID.randomUUID().toString());
        return playlistRepository.save(playlist);
    }

}
