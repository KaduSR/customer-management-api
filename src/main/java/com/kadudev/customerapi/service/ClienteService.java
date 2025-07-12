package com.kadudev.customerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadudev.customerapi.dto.ClienteRequest;
import com.kadudev.customerapi.dto.ClienteResponse;
import com.kadudev.customerapi.exception.ResourceNotFoundException;
import com.kadudev.customerapi.model.Cliente;
import com.kadudev.customerapi.model.Plano;
import com.kadudev.customerapi.repository.ClienteRepository;
import com.kadudev.customerapi.repository.PlanoRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PlanoRepository planoRepository;

    public ClienteService(ClienteRepository clienteRepository, PlanoRepository planoRepository) {
        this.clienteRepository = clienteRepository;
        this.planoRepository = planoRepository;
    }

    @Transactional
    public ClienteResponse createCliente(ClienteRequest clienteRequest) {
        if (repository.existsByCpf(clienteRequest.cpf())) {
            throw new ResourceNotFoundException("Já existe um cliente com este CPF");
        }
        if (repository.existsByEmail(clienteRequest.email())) {
            throw new ResourceNotFoundException("Já existe um cliente com este e-mail");
        }

        Cliente cliente = new Cliente(null, clienteRequest.nome(), clienteRequest.email(), clienteRequest.telefone(),
                clienteRequest.endereco(), clienteRequest.cpf());
        Cliente savedCliente = repository.save(cliente);
        return toResponse(savedCliente);
    }

    public List<ClienteResponse> getAllClientes() {
        return clienteRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public ClienteResponse getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return toResponse(cliente);
    }

    @Transactional
    public ClienteResponse updateCliente(Long id, ClienteRequest request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Plano plano = planoRepository.findById(request.planoId())
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));

        cliente.setNome(request.nome());
        cliente.setCpf(request.cpf());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        cliente.setEndereco(request.endereco());
        cliente.setPlano(plano);

        Cliente updated = clienteRepository.save(cliente);
        return toResponse(updated);
    }

    public void deleteCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getPlano().getId(), // adiciona info do plano
                cliente.getPlano().getNome() // opcional, se quiser mostrar o nome
        );
    }
}
