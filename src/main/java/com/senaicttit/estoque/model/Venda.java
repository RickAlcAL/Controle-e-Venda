package com.senaicttit.estoque.model;

import com.senaicttit.estoque.model.enums.Metodo;
import jakarta.persistence.*;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    //Dizendo que tem ID e que será um valor gerado automaticamente a cada inserimento de dados

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer idVenda;

    @Column(name = "valor_total")
    private Double valor_total;

    //Inserindo na tabela de forma de pagamento que é ENUM o formato ENUM
    @Column(name = "forma_pagamento")
    @Enumerated(EnumType.STRING)
    private Metodo forma_pagamento;

    public Venda(Integer idVenda, Double valor_total, Metodo forma_pagamento) {
        this.idVenda = idVenda;
        this.valor_total = valor_total;
        this.forma_pagamento = forma_pagamento;
    }

    public Venda() {

    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return this.idVenda;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }


    public Double getValor_total() {
        return valor_total;
    }

    public void setForma_pagamento(Metodo forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Enum getForma_pagamento() {
        return forma_pagamento;
    }
}
