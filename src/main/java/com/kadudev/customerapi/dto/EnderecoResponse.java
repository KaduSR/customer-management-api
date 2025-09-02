package com.kadudev.customerapi.dto;

public record EnderecoResponse(
        Long id,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep,
        Long clienteId
) {
    
}
