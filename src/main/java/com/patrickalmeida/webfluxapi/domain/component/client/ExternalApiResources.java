package com.patrickalmeida.webfluxapi.domain.component.client;

import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubRepositoryResponse;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubUserProfileResponse;
import com.patrickalmeida.webfluxapi.domain.component.client.response.GithubUsersSearch;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("github")
@Headers("Content-Type: application/json")
public interface ExternalApiResources {

    @RequestLine("GET /users/{username}/repos")
    List<GithubRepositoryResponse> getRepositories(@Param("username") String username);

    @RequestLine("GET /users/{username}")
    GithubUserProfileResponse getUserProfile(@Param("username") String username);

    @RequestLine("GET /search/users?q={q}")
    GithubUsersSearch getMultipleUsersWithStream(@Param("q") String query);

}
