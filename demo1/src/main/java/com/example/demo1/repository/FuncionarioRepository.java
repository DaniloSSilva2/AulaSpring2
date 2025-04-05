package com.example.demo1.repository;

import com.example.demo1.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository {
    Optional<Funcionario> findByCpf(String cpf);
}
