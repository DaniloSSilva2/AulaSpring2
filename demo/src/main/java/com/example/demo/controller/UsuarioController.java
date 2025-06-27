package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // Endpoint POST /usuarios
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuarioSalvo = usuarioService.salvarUsuario(usuarioDTO);
            UsuarioResponseDTO response = new UsuarioResponseDTO(usuarioSalvo.getName(), usuarioSalvo.getEmail());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // ou incluir mensagem: .body(null)
        }
    }
}
