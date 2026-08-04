package com.senaicttit.estoque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedores")
public class Fornecedor  {

    @Id
    //Dizendo que tem ID e que será um valor gerado automaticamente a cada inserimento de dados

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Integer id;

    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

    @Column(name = "cpf_ou_cnpj")
    private String cpfOucnpjFornecedor;

    @Column(name = "telefone_fornecedor")
    private String telefoneFornecedor;

    @Column(name = "email_fornecedor")
    private String emailFornecedor;

    @Column(name = "endereco_fornecedor")
    private String enderecoFornecedor;


    public Fornecedor(Integer id, String nomeFornecedor, String cpfOucnpjFornecedor, String telefoneFornecedor, String emailFornecedor, String enderecoFornecedor) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.cpfOucnpjFornecedor = cpfOucnpjFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
        this.emailFornecedor = emailFornecedor;
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public Fornecedor() {

    }

    public Integer getId() {
        return id;
    }

    public Fornecedor setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCpfOucnpjFornecedor() {
        return cpfOucnpjFornecedor;
    }

    public void setCpfOucnpjFornecedor(String cpfOucnpjFornecedor) {

        if (cpfOucnpjFornecedor == null || cpfOucnpjFornecedor.isEmpty()) {

            throw new RuntimeException("CPF ou CPNJ vazio");

        }

        String apenasNumeros = cpfOucnpjFornecedor.replaceAll("\\D", "");

        if (cpfOucnpjFornecedor.length() == 11 || cpfOucnpjFornecedor.length() == 14) {

            this.cpfOucnpjFornecedor = apenasNumeros;

        } else {

            throw new RuntimeException("CPF/CNPJ inválido! Deve conter 11 dígitos (CPF) ou 14 dígitos (CNPJ).");

        }
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        //Verificando se está vazio
        if (emailFornecedor == null || emailFornecedor.isBlank()) {

            throw new RuntimeException("Email vazio");

        }
        //Verificando se possui o @ no email do usuario
        if (emailFornecedor.contains("@")) {

            this.emailFornecedor = emailFornecedor;

        } else {

            throw new RuntimeException("Email faltando o @\nTente novamente com um email correto");

        }

    }

    public String getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(String enderecoFornecedor) {
        //Verificando se está vazio
        if (enderecoFornecedor == null || enderecoFornecedor.isEmpty()) {

            throw new RuntimeException("Endereço vazio");

        }

        this.enderecoFornecedor = enderecoFornecedor;

    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {

        if (nomeFornecedor == null || nomeFornecedor.isEmpty()) {

            throw new RuntimeException("Nome vazio");

        }

        this.nomeFornecedor = nomeFornecedor;

    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        //Verifico se esta vazio
        if (telefoneFornecedor == null || telefoneFornecedor.isBlank()) {

            throw new RuntimeException("Telefone vazio");

        }
        //Aqui estou pegando o número do usuario trocando e verificando se possui letras em vez de números
        String apenasNumero = telefoneFornecedor.replaceAll("\\D", "");

        if (apenasNumero.length() == 11) {

            this.telefoneFornecedor = apenasNumero;

        } else {

            throw new RuntimeException("Telefone precisa conter 11 caracteres com o DDD");

        }

    }

    @Override
    public String toString() {
        return "Nome fornecedor: " + getNomeFornecedor() +
                "CPF/CNPJ fornecedor: " + getCpfOucnpjFornecedor() +
                "Endereço do fornecedor: " + getEnderecoFornecedor() +
                "Email do fornecedor: " + getEmailFornecedor() +
                "Telefone do fornecedor: " + getTelefoneFornecedor();
    }
}
