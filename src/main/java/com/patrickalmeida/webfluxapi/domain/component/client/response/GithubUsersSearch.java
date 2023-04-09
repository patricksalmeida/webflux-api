package com.patrickalmeida.webfluxapi.domain.component.client.response;

import java.util.List;

public class GithubUsersSearch {

    private List<GithubUserProfileResponse> items;

    public List<GithubUserProfileResponse> getItems() {
        return items;
    }

    public void setItems(List<GithubUserProfileResponse> items) {
        this.items = items;
    }

}
