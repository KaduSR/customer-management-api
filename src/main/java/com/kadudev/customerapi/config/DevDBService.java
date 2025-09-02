package com.kadudev.customerapi.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.kadudev.customerapi.model.Plano;
import com.kadudev.customerapi.repository.PlanoRepository;

@Service
@Profile("dev")
public class DevDBService {

    @Autowired
    private PlanoRepository planoRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void instanciaDevDB() {
        Plano planoBasico = Plano.builder()
                .nome("Plano Básico")
                .descricao("Internet de 100MB")
                .valor(BigDecimal.valueOf(79.90))
                .build();

        planoRepository.save(planoBasico);
    }
}
