package com.soaint.rest.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Value("${connection.request.timeout}")
    private Integer connectionRequestTimeout;

    @Value("${connection.connect.timeout}")
    private Integer connectionConnectTimeout;

    @Value("${connection.read.timeout}")
    private Integer connectionReadTimeout;

    @Bean
    public RestTemplate restTemplate() {
        HttpClient httpClient = HttpClientBuilder.create()
                .build();

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setHttpClient(httpClient);
        httpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
        httpRequestFactory.setConnectTimeout(connectionConnectTimeout);
        httpRequestFactory.setReadTimeout(connectionReadTimeout);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setRequestFactory(httpRequestFactory);

        return restTemplate;
    }
}
