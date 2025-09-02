package com.kadudev.customerapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadudev.customerapi.dto.PlanoRequest;
import com.kadudev.customerapi.dto.PlanoResponse;
import com.kadudev.customerapi.service.PlanoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @Operation(summary = "Cria um novo plano", description = "Cria um novo plano com os dados fornecidos")
    @PostMapping
    public ResponseEntity<PlanoResponse> createPlano(@Valid @RequestBody PlanoRequest planoRequest) {
        PlanoResponse newPlano = planoService.createPlano(planoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlano);
    }

    @Operation(summary = "Retorna todos os planos", description = "Retorna uma lista de todos os planos cadastrados")
    @GetMapping
    public ResponseEntity<List<PlanoResponse>> getAllPlanos() {
        List<PlanoResponse> planos = planoService.getAllPlanos();
        return ResponseEntity.ok(planos);
    }

    @Operation(summary = "Retorna um plano por ID", description = "Retorna um plano específico com base no ID fornecido")
    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponse> getPlanoById(@PathVariable Long id) {
        PlanoResponse plano = planoService.getPlanoById(id);

        return ResponseEntity.ok(plano);
    }
}
