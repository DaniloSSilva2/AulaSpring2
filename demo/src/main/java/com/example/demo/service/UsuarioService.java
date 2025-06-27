package com.example.demo.service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public Usuario salvarUsuario(UsuarioDTO dto) {
        usuarioRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> {throw new IllegalArgumentException("Email já cadastrado."); });

        Usuario usuario = new Usuario();
        usuario.setName(dto.getNome());
        usuario.setEmail(dto.getEmail());

        return usuarioRepository.save(usuario);
    }


    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository
                .findAll() // List<Usuario>
                .stream() // Stream<Usuario>
                .map(usuario -> new UsuarioResponseDTO(usuario.getName(), usuario.getEmail()))
                .toList(); // List<UsuarioResponseDTO>
    }


}


















