package com.patrickalmeida.webfluxapi.domain.component.client;

import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubRepositoryResponse;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubRepositoriesResponse;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubUserProfileResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ExternalApiService {

    private ExternalApiResources externalApiResources;

    List<String> usernames = Arrays.asList("patricksalmeida");

    private ExternalApiResources getClient(ExternalApi externalApi) {
        if (Objects.nonNull(externalApiResources)) {
            return externalApiResources;
        }

        externalApiResources = new ExternalApiClient().getClient(externalApi);

        return externalApiResources;
    }

    public GithubRepositoriesResponse getGithubUserRepositories(ExternalApi externalApi, String username) {
        List<GithubRepositoryResponse> repositories = getClient(externalApi).getRepositories(username);
        return new GithubRepositoriesResponse(repositories);
    }

    public GithubUserProfileResponse getGithubUser(ExternalApi externalApi, String username) {
        return getClient(externalApi).getUserProfile(username);
    }

    public Flux<GithubRepositoryResponse> getManyUsersProfiles(ExternalApi externalApi) {
        ExternalApiResources client = getClient(externalApi);
        List<GithubUserProfileResponse> githubUsers = client.getMultipleUsersWithStream("location:brazil")
                .getItems()
                .subList(0, 10);

        return Flux.fromIterable(githubUsers)
                .delayElements(Duration.ofSeconds(5))
                .flatMap(user -> {
                    System.out.printf("Requesting repositories of user: %s\n", user.getLogin());
                    return Flux.fromStream(client.getRepositories(user.getLogin()).stream().findFirst().stream());
                });
    }

}
