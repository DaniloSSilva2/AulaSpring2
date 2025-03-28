package com.example.novodemo.service;


import com.example.novodemo.model.Usuario;
import com.example.novodemo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(@Valid Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");
        }
            return usuarioRepository.save(usuario);
    }

    public void excluir(String email) {
    Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    usuarioRepository.deleteById(usuario.getId());
    }

    public Usuario atualizar(@Valid Usuario usuario) {
        Usuario usuarioAtualizar = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

      usuarioAtualizar.setNome(usuario.getNome());
      usuarioAtualizar.setEmail(usuario.getEmail());
      usuarioAtualizar.setSenha(usuario.getSenha());



        return usuarioRepository.save(usuarioAtualizar);
    }












}
