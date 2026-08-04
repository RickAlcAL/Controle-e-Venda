package com.senaicttit.estoque.model;

import jakarta.persistence.*;


@Entity
@Table(name = "itens_venda")
public class ItensVenda{
    @Id
    //Dizendo que tem ID e que será um valor gerado automaticamente a cada inserimento de dados

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_item")
    private Integer id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_unitario")
    private Double precoUnitario;

    @Column (name = "subtotal")
    private Double subtotal;

    //Relacionamento entre tabelas, a caada produto tem seu fornecedor
    //Usando ManyToOne para falar que aqui está a chave estrangeira da tabela fornecedor
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda vendas;

    public ItensVenda(Integer id, Integer quantidade, Double precoUnitario, Double subtotal) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = subtotal;
    }
    public ItensVenda() {

    }

    public Venda getVendas() {
        return vendas;
    }

    public void setVendas(Venda vendas) {
        this.vendas = vendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
