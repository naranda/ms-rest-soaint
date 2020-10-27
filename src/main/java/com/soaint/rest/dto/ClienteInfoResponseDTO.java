package com.soaint.rest.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "ClienteInfoResponse", description = "Información básica del cliente")
public class ClienteInfoResponseDTO {

    private String idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String telefonoCelular;
}
