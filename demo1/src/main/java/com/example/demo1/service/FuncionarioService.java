package com.example.demo1.service;

import com.example.demo1.model.Funcionario;
import com.example.demo1.model.Usuario;
import com.example.demo1.repository.FuncionarioRepository;
import com.example.demo1.repository.UsuarioRepository;
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
            return funcionarioRepository.save(funcionario);
        }

        public Funcionario atualizar(@Valid Funcionario funcionario) {
            Usuario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

            funcionarioAtualizar.setNome(funcionario.getNome());
            funcionarioAtualizar.setCpf(funcionario.getCpf());
            usuarioAtualizar.setSenha(usuarioAtualizar.getSenha());

            return usuarioRepository.save(usuarioAtualizar);
        }

        public void excluir(Long id) {
            Usuario usuarioAtualizar = usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
            usuarioRepository.deleteById(usuarioAtualizar.getId());
        }












































}
