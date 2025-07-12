package com.kadudev.customerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadudev.customerapi.dto.PlanoRequest;
import com.kadudev.customerapi.dto.PlanoResponse;
import com.kadudev.customerapi.exception.ResourceNotFoundException;
import com.kadudev.customerapi.model.Plano;
import com.kadudev.customerapi.repository.PlanoRepository;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Transactional
    public PlanoResponse createPlano(PlanoRequest request) {
        Plano plano = new Plano();
        plano.setNome(request.nome());
        plano.setValor(request.valor());
        plano.setVelocidadeMbps(request.velocidadeMbps());
        plano.setDescricao(request.descricao());

        Plano saved = planoRepository.save(plano);
        return toResponse(saved);
    }

    private PlanoResponse toResponse(Plano saved) {
        throw new UnsupportedOperationException("Unimplemented method 'toResponse'");
    }

    public List<PlanoResponse> getAllPlanos() {
        return planoRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public PlanoResponse getPlanoById(Long id) {
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
        return toResponse(plano);
    }

    @Transactional
    public PlanoResponse updatePlano(Long id, PlanoRequest request) {
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));

        plano.setNome(request.nome());
        plano.setValor(request.valor());
        plano.setVelocidadeMbps(request.velocidadeMbps());
        plano.setDescricao(request.descricao());

        Plano updated = planoRepository.save(plano);
        return toResponse(updated);
    }

    public void deletePlano(Long id)
    {
        
    }
}