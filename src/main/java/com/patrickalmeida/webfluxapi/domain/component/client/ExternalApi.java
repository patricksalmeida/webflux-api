package com.patrickalmeida.webfluxapi.domain.component.client;

public class ExternalApi {

    private String baseUrl;

    public ExternalApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
