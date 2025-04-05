package com.example.demo1.controller;

import com.example.demo1.model.Usuario;
import com.example.demo1.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    @GetMapping
    public List<Usuario> ListatTodos() {
        return usuarioService.listarTodos();

    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Usuario criado com sucesso."));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Usuário" + usuario.getNome() + "atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Usuário deletado com sucesso."));
    }















}
