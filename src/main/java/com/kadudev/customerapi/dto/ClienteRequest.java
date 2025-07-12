package com.kadudev.customerapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
                @NotBlank(message = "O nome é obrigatório") @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres") String nome,

                @NotBlank(message = "O CPF é obrigatório") @Pattern(regexp = "\\d{11}", message = "CPF inválido") String cpf,

                @NotBlank(message = "O e-mail é obrigatório") @Email(message = "E-mail inválido") @Size(max = 100, message = "O e-mail não pode ter mais de 100 caracteres") String email,

                @NotBlank(message = "O telefone é obrigatório") @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido") String telefone,

                @NotBlank(message = "O endereço é obrigatório") @Size(max = 255, message = "O endereço não pode ter mais de 255 caracteres") String endereco,
                @NotBlank(message = "O ID do plano é obrigatório") Long planoId) {
}
