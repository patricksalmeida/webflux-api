package com.patrickalmeida.webfluxapi.domain.repository;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
