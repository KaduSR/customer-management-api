package com.kadudev.customerapi.dto;

public record ClienteResponse(
                Long id,
                String nome,
                String cpf,
                String email,
                String telefone,
                String endereço,
                Long planoId,
                String planoNome

) {
}
