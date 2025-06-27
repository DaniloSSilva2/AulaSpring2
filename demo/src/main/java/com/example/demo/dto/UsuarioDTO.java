package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Emai deve ser válido")
    private String email;
    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 6, message = "Deve ter no mínimo 6 caracteres")
    private String senha;

    public UsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDTO() {
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Emai deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Emai deve ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Senha é obrigatório") @Size(min = 6, message = "Deve ter no mínimo 6 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatório") @Size(min = 6, message = "Deve ter no mínimo 6 caracteres") String senha) {
        this.senha = senha;
    }
}

