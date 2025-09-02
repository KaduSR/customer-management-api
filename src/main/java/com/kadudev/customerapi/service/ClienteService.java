package com.kadudev.customerapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadudev.customerapi.dto.ClienteRequest;
import com.kadudev.customerapi.dto.ClienteResponse;
import com.kadudev.customerapi.exception.ResourceNotFoundException;
import com.kadudev.customerapi.model.Cliente;
import com.kadudev.customerapi.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ClienteResponse createCliente(ClienteRequest clienteRequest) {
        if (repository.existsByCpf(clienteRequest.cpf())) {
            throw new ResourceNotFoundException("Já existe um cliente com este CPF");
        }
        if (repository.existsByEmail(clienteRequest.email())) {
            throw new ResourceNotFoundException("Já existe um cliente com este e-mail");
        }

        Cliente cliente = new Cliente(null, clienteRequest.nome(), clienteRequest.cpf(), clienteRequest.email(),
                clienteRequest.telefone(), clienteRequest.endereco(), null);
        Cliente savedCliente = repository.save(cliente);
        return toResponse(savedCliente);
    }

    public List<ClienteResponse> getAllClientes() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponse getClienteById(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return toResponse(cliente);
    }

    @Transactional
    public ClienteResponse updateCliente(Long id, ClienteRequest clienteRequest) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        // Atualiza os dados do cliente
        cliente.setNome(clienteRequest.nome());
        cliente.setCpf(clienteRequest.cpf());
        cliente.setEmail(clienteRequest.email());
        cliente.setTelefone(clienteRequest.telefone());
        cliente.setEndereco(clienteRequest.endereco());

        repository.save(cliente);
        return toResponse(cliente);
    }

    @Transactional
    public void deleteCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }

    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(),
                cliente.getTelefone(), cliente.getEndereco());
    }
}