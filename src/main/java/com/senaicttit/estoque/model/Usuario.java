package com.senaicttit.estoque.model;

import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "senha_hash")
    private String senhaHash;
    // getters e setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nomeUsuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nomeUsuario = nome_usuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
}
