package com.kadudev.customerapi.dto;

public record ClienteResponse(
                Long id,
                String nome,
                String cpf,
                String email,
                String telefone,
                String endereco,
                Long planoId,
                String planoNome

) {
}
