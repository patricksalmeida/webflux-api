package com.patrickalmeida.webfluxapi.domain.component.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUserProfileResponse {

    private long id;

    private String login;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
