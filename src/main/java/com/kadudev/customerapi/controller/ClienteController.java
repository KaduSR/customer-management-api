package com.kadudev.customerapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadudev.customerapi.dto.ClienteRequest;
import com.kadudev.customerapi.dto.ClienteResponse;
import com.kadudev.customerapi.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Cria um novo cliente", description = "Cria um novo cliente com os dados fornecidos")
    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse newCliente = clienteService.createCliente(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
    }

    @Operation(summary = "Retorna todos os clientes", description = "Retorna uma lista de todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAllClientes() {
        List<ClienteResponse> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Retorna um cliente por ID", description = "Retorna um cliente específico com base no ID fornecido")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getClienteById(@PathVariable Long id) {
        ClienteResponse cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Atualiza um cliente existente", description = "Atualiza os dados de um cliente existente com base no ID e nos dados fornecidos")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> updateCliente(@PathVariable Long id, @Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse updatedCliente = clienteService.updateCliente(id, clienteRequest);
        return ResponseEntity.ok(updatedCliente);
    }

    @Operation(summary = "Exclui um cliente", description = "Exclui um cliente existente com base no ID fornecido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }


}
