package com.example.funcionario.repository;

import com.example.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository {
    Optional<Funcionario> findByCpf(String cpf);
}
