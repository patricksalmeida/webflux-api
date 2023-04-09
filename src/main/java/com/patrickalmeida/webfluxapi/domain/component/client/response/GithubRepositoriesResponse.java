package com.patrickalmeida.webfluxapi.domain.component.client.response;

import java.util.List;

public class GithubRepositoriesResponse {

    private List<GithubRepositoryResponse> repositories;

    public GithubRepositoriesResponse(List<GithubRepositoryResponse> repositories) {
        this.repositories = repositories;
    }

    public List<GithubRepositoryResponse> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<GithubRepositoryResponse> repositories) {
        this.repositories = repositories;
    }
}
