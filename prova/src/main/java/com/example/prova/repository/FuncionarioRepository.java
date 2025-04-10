package com.example.prova.repository;

import com.example.prova.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// Interface de repositório JPA para a entidade Funcionario.
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Consulta para buscar funcionário pelo e-mail.
Optional<Funcionario> findByEmail(String Email);

}
