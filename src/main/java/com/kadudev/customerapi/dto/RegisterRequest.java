package com.kadudev.customerapi.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank(message = "O nome de usuário é obrigatório") String username,
        @NotBlank(message = "A senha é obrigatória") String password) {
}
