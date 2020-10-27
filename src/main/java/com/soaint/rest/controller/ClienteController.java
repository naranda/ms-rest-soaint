package com.soaint.rest.controller;

import com.soaint.rest.dto.ClienteInfoResponseDTO;
import com.soaint.rest.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Cliente", tags = { "Cliente" })
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Get Info Cliente", response = ClienteInfoResponseDTO.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/cliente/{rut}/canal/{canal}")
    public ResponseEntity<ClienteInfoResponseDTO> getInfoCliente(@PathVariable(name = "rut") String rut, @PathVariable(name = "canal") String canal)  {
        return new ResponseEntity<>(clienteService.getInfoCliente(rut, canal), HttpStatus.OK);
    }

}
