package com.example.funcionario.service;

import com.example.funcionario.model.Funcionario;
import com.example.funcionario.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;

    }


    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();

    }

    public Funcionario salvar(@Valid Funcionario funcionario) {
        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw  new RuntimeException("Usuário já cadeastrado.");
        }
        return (Funcionario) funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario) throws Throwable {
        Funcionario funcionarioAtualizar = (Funcionario) funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setRg(funcionario.getRg());
        funcionarioAtualizar.setMatricula(funcionario.getMatricula());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setSalario(funcionario.getSalario());

        return (Funcionario) funcionarioRepository.save(funcionarioAtualizar);
    }


    public void excluir(Long id) throws Throwable {
        Funcionario funcionarioAtualizar = (Funcionario) funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        funcionarioRepository.deleteById(funcionarioAtualizar.getId());
    }









}
