package com.kadudev.customerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public ClienteResponse createCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente(null, clienteRequest.nome(), clienteRequest.email(), clienteRequest.telefone(),
                clienteRequest.endereco(), clienteRequest.cpf());
        Cliente savedCliente = repository.save(cliente);
        return toResponse(savedCliente);
    }

    public List<ClienteResponse> getAllClientes() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ClienteResponse getClienteById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return toResponse(cliente);
    }

    public ClienteResponse updateCliente(Long id, ClienteRequest clienteRequest) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        cliente.setNome(clienteRequest.nome());
        cliente.setEmail(clienteRequest.email());
        cliente.setTelefone(clienteRequest.telefone());
        cliente.setEndereco(clienteRequest.endereco());
        cliente.setCpf(clienteRequest.cpf());
        repository.save(cliente);
        return toResponse(cliente);
    }

    public void deleteCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
    }

}