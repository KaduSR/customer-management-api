package com.kadudev.customerapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kadudev.customerapi.dto.EnderecoResponse;
import com.kadudev.customerapi.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoResponse> getAllEnderecos() {
        return enderecoRepository.findAll().stream()
                .map(endereco -> new EnderecoResponse(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(),
                        endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep(),
                        endereco.getCliente().getId()))
                .collect(Collectors.toList());
    }

}
