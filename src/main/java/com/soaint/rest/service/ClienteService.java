package com.soaint.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soaint.rest.adapter.DatabaseRestAdapter;
import com.soaint.rest.dto.ClienteInfoResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = {"clienteService"})
public class ClienteService {


    @Autowired
    private DatabaseRestAdapter databaseRestAdapter;

    @Cacheable(cacheNames = {"clienteService"})
    public ClienteInfoResponseDTO getInfoCliente(String rut, String canal) {
        log.debug("getInfoCliente: RUT= {} CANAL= {}",rut,canal);

        rut = rutFormatter(rut);
        rut = rut.toUpperCase();

        log.debug("Rut formateado: RUT = {}",rut);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonResponse = databaseRestAdapter.getInfoCliente(rut, canal);

        ClienteInfoResponseDTO clienteInfoResponseDTO = null;
        try {
            clienteInfoResponseDTO = objectMapper.treeToValue(jsonResponse, ClienteInfoResponseDTO.class);
        } catch (JsonProcessingException e) {
            log.debug(e.getMessage());
        }

        return clienteInfoResponseDTO;
    }

    private String rutFormatter(String rut){
        String formatter="";
        rut = rut.replace("-","");
        rut = rut.replace(".","");
        if(rut.length() < 15){
            int size = 15 - rut.length();
            formatter = rut;
            String tmp ="";
            for(int i=0; i<size; i++){
                tmp = tmp.concat("0");
            }
            rut = tmp+formatter;
        }

        return rut;
    }
}
