package com.example.demos.controller;

import com.example.demos.model.Usuario;
import com.example.demos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    @GetMapping
    public List<Usuario> ListatTodos() {
        return usuarioService.ListarTodos();

    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Usuario cadastrado com sucesso."));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Usuário" + usuario.getEmail() + "atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Usuário deletado com sucesso."));
    }










































}