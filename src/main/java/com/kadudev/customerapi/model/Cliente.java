package com.kadudev.customerapi.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "plano")
@EqualsAndHashCode(of = "id")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres")
    private String nome;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos")
    private String cpf;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Size(max = 100, message = "O e-mail não pode ter mais de 100 caracteres")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos")
    private String telefone;

    @Column(nullable = false)
    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 255, message = "O endereço não pode ter mais de 255 caracteres")
    private String endereco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCadastro;


}
