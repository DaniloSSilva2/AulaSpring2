package com.example.atividade.service;

import com.example.atividade.model.Funcionario;
import com.example.atividade.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }

    public Funcionario criar(Funcionario funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        return repository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario novo) {
        Funcionario existente = buscarPorId(id);

        if (!existente.getEmail().equals(novo.getEmail()) &&
                repository.findByEmail(novo.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        novo.setId(id);
        return repository.save(novo);
    }

    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }

}
