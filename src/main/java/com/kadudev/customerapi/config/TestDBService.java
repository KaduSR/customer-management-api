package com.kadudev.customerapi.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kadudev.customerapi.model.Cliente;
import com.kadudev.customerapi.model.Plano;
import com.kadudev.customerapi.model.User;
import com.kadudev.customerapi.repository.ClienteRepository;
import com.kadudev.customerapi.repository.PlanoRepository;
import com.kadudev.customerapi.repository.UserRepository;

@Service
@Profile("test")
public class TestDBService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void instanciaTestDB() {
        // Criar plano
        Plano planoTeste = Plano.builder()
                .nome("Plano Teste")
                .descricao("Internet de Teste")
                .valor(BigDecimal.valueOf(0))
                .build();

        planoRepository.save(planoTeste);

        // Criar cliente
        Cliente cliente = Cliente.builder()
                .nome("Cliente Teste")
                .cpf("12345678901")
                .email("teste@cliente.com")
                .telefone("11999999999")
                .endereco("Rua Teste, 123")
                .plano(planoTeste)
                .build();

        clienteRepository.save(cliente);

        // Criar usuário padrão
        String username = "admin@example.com";
        if (!usuarioRepository.existsByUsername(username)) {
            User admin = User.builder()
                    .username(username)
                    .password(passwordEncoder.encode("123456"))
                    .role("ADMIN")
                    .build();

            usuarioRepository.save(admin);
            System.out.println("✅ Usuário ADMIN de teste criado.");
        } else {
            System.out.println("ℹ️ Usuário ADMIN já existe.");
        }
    }
}