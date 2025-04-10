package com.example.prova.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/dev") // Define o caminho base das rotas deste controlador como "/dev".
public class Dev {
    // Mapeia requisições HTTP GET e retorna "Danilo de Santana Silva".
    @GetMapping
    public ResponseEntity<String> dev() {
        return ResponseEntity.ok("Danilo de Santana Silva.");
    }
}
