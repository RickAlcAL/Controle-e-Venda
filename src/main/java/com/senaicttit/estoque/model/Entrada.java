package com.senaicttit.estoque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entradas")
public class Entrada  {
    //Dizendo que tem ID e que será um valor gerado automaticamente a cada inserimento de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Integer id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_custo_unitario")
    private Double precoUnitarioDosProdutos;

    public Entrada(Integer id, Integer quantidade, Double precoUnitarioDosProdutos, Fornecedor fornecedor, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitarioDosProdutos = precoUnitarioDosProdutos;
        this.produto = produto;
    }

    public Entrada() {

    }
    //Relacionamento entre tabelas, a caada produto tem seu fornecedor
    //Usando ManyToOne para falar que aqui está a chave estrangeira da tabela fornecedor

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    //A cada busca do fornecedor pelo nome o ID e o Nome gerado será adicionado ao Set


    public Entrada setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }


    public Double getPrecoUnitarioDosProdutos() {
        return precoUnitarioDosProdutos;
    }

    public void setPrecoUnitarioDosProdutos(Double precoUnitarioDosProdutos) {

        if (precoUnitarioDosProdutos <= 0) {

            throw new RuntimeException("Preço não pode ser 0 ou negativo");

        }

        this.precoUnitarioDosProdutos = precoUnitarioDosProdutos;

    }


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        if (quantidade <= 0) {

            throw new RuntimeException("Quantidade deve ser positivo");

        }

        this.quantidade = quantidade;

    }

    @Override
    public String toString() {
        return "Preço unitario: R$" + getPrecoUnitarioDosProdutos();
    }
}
