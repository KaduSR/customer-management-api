package com.kadudev.customerapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PlanoRequest(
        @NotBlank(message = "O nome do plano é obrigatório") @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres") String nome,

        @NotNull(message = "O valor do plano é obrigatório") @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero") BigDecimal valor,

        @NotNull(message = "A velocidade do plano é obrigatória") @Min(value = 1, message = "A velocidade deve ser no mínimo 1 Mbps") Integer velocidadeMbps,

        @NotBlank(message = "A descrição do plano é obrigatória") @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres") String descricao) {
}
