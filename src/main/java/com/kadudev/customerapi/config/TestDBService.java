package com.kadudev.customerapi.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.kadudev.customerapi.model.Cliente;
import com.kadudev.customerapi.model.Plano;
import com.kadudev.customerapi.repository.ClienteRepository;
import com.kadudev.customerapi.repository.PlanoRepository;

@Service
@Profile("test")
public class TestDBService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void instanciaTestDB() {
        Plano planoTeste = Plano.builder()
                .nome("Plano Teste")
                .descricao("Internet de Teste")
                .valor(BigDecimal.valueOf(0))
                .build();

        planoRepository.save(planoTeste);

        Cliente cliente = Cliente.builder()
                .nome("Cliente Teste")
                .cpf("12345678901")
                .email("teste@cliente.com")
                .telefone("11999999999")
                .endereco("Rua Teste, 123")
                .plano(planoTeste)
                .build();

        clienteRepository.save(cliente);
    }
}
