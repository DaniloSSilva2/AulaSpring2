package com.example.atividade.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Boas Vindas!");
    }

    @GetMapping("/dev")
    public ResponseEntity<String> dev() {
        return ResponseEntity.ok("Danilo de Santana Silva.");
    }
}
