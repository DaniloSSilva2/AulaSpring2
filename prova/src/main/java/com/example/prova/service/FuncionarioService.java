package com.example.prova.service;

import com.example.prova.model.Funcionario;
import com.example.prova.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service // Define a classe como um serviço do Spring
@Validated // Permite validação
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // Lista todos os funcionários cadastrados
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    // Salva novo funcionário após verificar se e-mail já existe
    public Funcionario salvar(@Valid Funcionario funcionario) {
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Usuario já cadastrado.");
        }
        return funcionarioRepository.save(funcionario);
    }

    // Atualiza um funcionário existente, lançando erro se não encontrado
    public Funcionario atualizar(@Valid Funcionario funcionario) {
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());
        funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSalario(funcionario.getSalario());

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    // Exclui funcionário por ID, se encontrado
    public void excluir(Long id) {
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        funcionarioRepository.deleteById(id);
    }

}































