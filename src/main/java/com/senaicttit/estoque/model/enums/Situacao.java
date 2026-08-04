package com.senaicttit.estoque.model.enums;

public enum Situacao {
    //Situações com mensagens pre programadas
    CONFIRMADO ("Situação confirmada\nAguarde..."),
    RECUSADO ("Erro\nTente novamente..."),
    FORMAS_PAGAMENTO ("Cartão de Crédito , Dinheiro, Cartao_Debito, Pix");

    private final String msgUser;

    Situacao (String msgUser){
        this.msgUser = msgUser;
    }

    public String getMsgUser() {
        return msgUser;
    }
}
