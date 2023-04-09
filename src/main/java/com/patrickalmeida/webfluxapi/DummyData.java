package com.patrickalmeida.webfluxapi;

import com.patrickalmeida.webfluxapi.domain.model.Playlist;
import com.patrickalmeida.webfluxapi.domain.repository.PlaylistRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class DummyData implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    public DummyData(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        playlistRepository
                .deleteAll()
                .thenMany(savePlaylists())
                .subscribe(System.out::println);
    }

    private Flux<Playlist> savePlaylists() {
        return Flux.just(
                "API Rest Spring boot",
                        "Deploy de uma aplicação web",
                        "Github",
                        "Utilizando Spring Webflux",
                        "DevOps",
                        "Kubernetes",
                        "Gitflow",
                        "Usando DDD da forma certa",
                        "API Gateway utilizando Kong",
                        "Implementando autenticação utilizando Spring Security",
                        "Automatizando infraestrutura com Ansible")
                .map(playlistName -> new Playlist(UUID.randomUUID().toString(), playlistName,  ThreadLocalRandom.current().nextInt(1, 100 + 1)))
                .flatMap(playlistRepository::save);
    }
}
