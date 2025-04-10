package com.example.prova.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/") // Define o caminho base das rotas deste controlador como "/".
public class Welcome {
    // Mapeia requisições HTTP GET e retorna "Boas Vindas!".
    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Boas Vindas!");
    }
}
