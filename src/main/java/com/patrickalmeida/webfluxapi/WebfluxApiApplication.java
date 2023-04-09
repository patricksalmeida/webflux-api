package com.patrickalmeida.webfluxapi;

import com.patrickalmeida.webfluxapi.domain.repository.PlaylistRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableMongoRepositories
public class WebfluxApiApplication {

	private final PlaylistRepository playlistRepository;

	public WebfluxApiApplication(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApiApplication.class, args);
	}

	@PostConstruct()
	public void initializeDatabase() throws Exception {
//		Uncommment this method to populate database
//		new DummyData(playlistRepository).run();
	}


}
