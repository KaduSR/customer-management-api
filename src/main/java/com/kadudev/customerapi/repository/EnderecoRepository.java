package com.kadudev.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadudev.customerapi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    

}
