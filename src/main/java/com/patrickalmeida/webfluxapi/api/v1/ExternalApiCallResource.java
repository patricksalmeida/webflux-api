package com.patrickalmeida.webfluxapi.api.v1;

import com.patrickalmeida.webfluxapi.domain.component.client.ExternalApi;
import com.patrickalmeida.webfluxapi.domain.component.client.ExternalApiService;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubRepositoriesResponse;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubRepositoryResponse;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubUserProfileResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/external")
public class ExternalApiCallResource {

    private final ExternalApiService externalApiService;

    public ExternalApiCallResource(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/{username}/repos")
    public GithubRepositoriesResponse getUserRepositories(@PathVariable String username) {
        ExternalApi externalApi = new ExternalApi("https://api.github.com");
        return externalApiService.getGithubUserRepositories(externalApi, username);
    }


    @GetMapping("/{username}/profile")
    public GithubUserProfileResponse getUserProfile(@PathVariable String username) {
        ExternalApi externalApi = new ExternalApi("https://api.github.com");
        return externalApiService.getGithubUser(externalApi, username);
    }

    @GetMapping(value = "/github/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<GithubRepositoryResponse> getMultipleUsers() {
        ExternalApi externalApi = new ExternalApi("https://api.github.com");
        return externalApiService.getManyUsersProfiles(externalApi);
    }

}
