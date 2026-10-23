package com.senaicttit.estoque.model;

import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "sobrenome_usuario")
    private String sobrenomeUsuario;
    @Column(name = "senha_hash")
    private String senhaHash;
    @Column(name = "endereco_usuario")
    private String enderecoUsuario;
    @Column(name = "cep_usuario")
    private String cepUsuario;
    @Column(name = "estado_usuario")
    private String estadoUsuario;
    @Column(name = "cidade_usuario")
    private String cidadeUsuario;
    @Column(name = "numero_casa_usuario")
    private String numeroUsuario;
    @Column(name = "telefone_usuario")
    private String telefoneUsuario;
    @Column
    private String observacao_usuario;
    @Column(name = "observacaoUsuario")
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

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getCidadeUsuario() {
        return cidadeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCidadeUsuario(String cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public String getObservacao_usuario() {
        return observacao_usuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setObservacao_usuario(String observacao_usuario) {
        this.observacao_usuario = observacao_usuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public String getCepUsuario() {
        return cepUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setCepUsuario(String cepUsuario) {
        this.cepUsuario = cepUsuario;
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
