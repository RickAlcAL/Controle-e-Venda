package com.senaicttit.estoque.model;


import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto  {
    @Id
    //Dizendo que tem ID e que será um valor gerado automaticamente a cada inserimento de dados

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "preco_produto")
    private Double precoProduto;

    @Column(name = "quantidade_estoque")
    private Integer quantidadeProduto;


    //Relacionamento entre tabelas, a caada produto tem seu fornecedor
    //Usando ManyToOne para falar que aqui está a chave estrangeira da tabela fornecedor
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(Integer id, String nomeProduto, Double precoProduto, Integer quantidadeProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto() {

    }


    public Double getPrecoProduto() {
        return precoProduto;
    }

    //Metodo setter que está recebendo um cálculo para validação
    public void setPrecoProduto(Double precoProduto) {

        if (precoProduto == null || precoProduto <= 0) {

            throw new RuntimeException("Valor não pode ser nulo,0 ou menor\nDeve ser positivo");

        }

        this.precoProduto = precoProduto;

    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    //Metodo setter que está recebendo um cálculo para validação
    public void setQuantidadeProduto(Integer quantidadeProduto) {
        if (quantidadeProduto <= 0) {

            throw new RuntimeException("Quantidade deve ser positivo");

        }
        this.quantidadeProduto = quantidadeProduto;

    }

    public Integer getId() {
        return id;
    }

    public Produto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    //Metodo setter que está recebendo um cálculo para validação
    public void setNomeProduto(String nomeProduto) {

        if (nomeProduto.isEmpty()) {

            throw new RuntimeException("Preencha o nome do produto");

        }

        this.nomeProduto = nomeProduto;

    }

    @Override
    public String toString() {
        return "Nome do produto: " + getNomeProduto() +
                "Preço do produto: " + getPrecoProduto() +
                "Quantidade do produto: " + getQuantidadeProduto();
    }
}
