package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, message = "Deve ter 6 ou mais caracteres.")
    private String senha;

    public Usuario() {
    }

    public Usuario(long id, String name, String email, String senha) {
        this.id = id;
        this.nome = name;
        this.email = email;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return nome;
    }

    public void setName(@NotBlank String name) {
        this.nome = name;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 6, message = "Deve ter 6 ou mais caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank @Size(min = 6, message = "Deve ter 6 ou mais caracteres.") String senha) {
        this.senha = senha;
    }
}
