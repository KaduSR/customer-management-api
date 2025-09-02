package com.kadudev.customerapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoRequest(
        @NotBlank(message = "O logradouro é obrigatório") @Size(max = 100, message = "O logradouro não pode ter mais de 100 caracteres") String logradouro,

        @NotBlank(message = "O número é obrigatório") @Size(max = 10, message = "O número não pode ter mais de 10 caracteres") String numero,

        @NotBlank(message = "O bairro é obrigatório") @Size(max = 50, message = "O bairro não pode ter mais de 50 caracteres") String bairro,

        @NotBlank(message = "A cidade é obrigatória") @Size(max = 50, message = "A cidade não pode ter mais de 50 caracteres") String cidade,

        @NotBlank(message = "O estado é obrigatório") @Size(max = 2, message = "O estado deve ter exatamente 2 caracteres") String estado,

        @NotBlank(message = "O CEP é obrigatório") @Pattern(regexp = "\\d{8}", message = "CEP inválido") String cep,

        @NotBlank(message = "O ID do cliente é obrigatório") Long clienteId


) {
    
}
