package com.kadudev.customerapi.repository;

import com.kadudev.customerapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

}
