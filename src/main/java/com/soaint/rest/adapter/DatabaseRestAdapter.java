package com.soaint.rest.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class DatabaseRestAdapter {
    @Value("${rest.database.url}")
    private String restDatabaseServiceEndpoint;

    @Value("${rest.database.path}")
    private String restDatabaseServicePath;

    @Autowired
    private RestTemplate restTemplate;

    public JsonNode getInfoCliente(String rut, String canal) {
        log.debug("Consultando info cliente rut: {} canal: {}",rut,canal);

        String urlTemplate = restDatabaseServiceEndpoint.concat(restDatabaseServicePath);

        String url = urlTemplate
                .replace(":rut", rut).replace(":canal", canal);

        log.debug("URL: " + url);

        ResponseEntity<JsonNode> exchange = null;


        exchange = restTemplate.exchange(url, HttpMethod.GET, null, JsonNode.class);


        log.debug("Respuesta: {}", exchange);

        JsonNode response = exchange.getBody();

        return response;
    }
}
