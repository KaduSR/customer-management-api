package com.kadudev.customerapi.dto;

import java.math.BigDecimal;

public record PlanoResponse(
        Long id,
        String nome,
        BigDecimal valor,
        Integer velocidadeMbps,
        String descricao) {
}
