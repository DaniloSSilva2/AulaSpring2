package com.example.demos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "O E-mail deve ser válido.")
    private String email;

    @NotBlank(message = "Senha é obrigatório.")
    @Size(min = 3,message = "A senha deve ter no mínimo 3 caracteres.")
    private String senha;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    public Usuario() {
    }

    public Usuario(long id, String email, String senha, String nome) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank @Size String senha) {
        this.senha = senha;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }
}
