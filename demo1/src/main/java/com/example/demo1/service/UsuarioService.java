package com.example.demo1.service;

import com.example.demo1.model.Usuario;
import com.example.demo1.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {

      private UsuarioRepository usuarioRepository;

      public UsuarioService(UsuarioRepository usuarioRepository) {
          this.usuarioRepository = usuarioRepository;

      }


      public List<Usuario> listarTodos(){
          return usuarioRepository.findAll();

      }

    public Usuario salvar(@Valid Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw  new RuntimeException("Usuário já cadeastrado.");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(@Valid Usuario usuario) {
        Usuario usuarioAtualizar = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setEmail(usuario.getEmail());
        usuarioAtualizar.setSenha(usuarioAtualizar.getSenha());

        return usuarioRepository.save(usuarioAtualizar);
    }

    public void excluir(Long id) {
        Usuario usuarioAtualizar = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.deleteById(usuarioAtualizar.getId());
    }


















}
