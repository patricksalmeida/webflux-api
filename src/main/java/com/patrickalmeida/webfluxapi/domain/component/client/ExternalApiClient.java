package com.patrickalmeida.webfluxapi.domain.component.client;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class ExternalApiClient {

    public ExternalApiResources getClient(ExternalApi externalApi) {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .logLevel(Logger.Level.BASIC)
                .target(ExternalApiResources.class, externalApi.getBaseUrl());
    }

}
