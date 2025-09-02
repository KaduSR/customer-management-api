package com.kadudev.customerapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implemente a busca do usuário no banco de dados ou outra fonte
        // Exemplo simples (substitua pela lógica real):
        throw new UsernameNotFoundException("Usuário não encontrado: ");
    }
}