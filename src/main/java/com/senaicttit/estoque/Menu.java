package com.senaicttit.estoque;

import com.senaicttit.estoque.model.*;
import com.senaicttit.estoque.model.enums.Metodo;
import com.senaicttit.estoque.model.enums.Situacao;
import com.senaicttit.estoque.service.*;

import java.util.InputMismatchException;
import java.util.Scanner;
//Inicializando e atribuindo as Classes

public class Menu {
    FornecedorService fornecedorVerf = new FornecedorService();
    EntradaService entradaVerf = new EntradaService();
    ProdutoService prod = new ProdutoService();
    Produto produto = new Produto();
    Fornecedor fornecedor = new Fornecedor();
    Entrada entradaItens = new Entrada();
    ItensVenda itensVenda = new ItensVenda();
    ItensVendaService itenvsVendaF = new ItensVendaService();
    Venda venda = new Venda();
    VendaService vendaVerf = new VendaService();

    //Menu basico
    public void menuUsuario() {

        Scanner sc = new Scanner(System.in);
        boolean situacao = true;
        Integer opcao = null;

        while (situacao) {

            System.out.println(" ===================== ");
            System.out.println("Boas - Vindas !!! \n" +
                    "Ao serviço de controle\n" +
                    "Prossiga com sua operação");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Se cadastrar como fornecedor");
            System.out.println("3 - Verificar fornecedores ");
            System.out.println("4 - Verificar estoque");
            System.out.println(" ===================== ");

            try {

                opcao = sc.nextInt();

                if (opcao <= 0) {

                    System.out.println("Número invalido");
                    situacao = false;

                }

            } catch (InputMismatchException | NumberFormatException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());
                sc.nextLine(); //Limpeza de buffer, caso o usuário digite algo fora do padrão volta para o começo

            }

            switch (opcao) {

                case 1:

                    sc.nextLine(); //Limpeza de buffer após um número inserido
                    menuProduto();
                    break;

                case 2:

                    sc.nextLine();//Limpeza de buffer após um número inserido
                    if (fornecedor.getNomeFornecedor().isEmpty()) {
                        menuFornecedor();
                    }

                    break;

                case 3:

                    sc.nextLine();
                    break;

                case 4:

                    sc.nextLine(); //Limpeza de buffer após um número inserido
                    break;

            }
        }
    }

    //Menu do fornecedor
    public void menuFornecedor() {

        Scanner sc = new Scanner(System.in);
        //Criando um laço while para cada informação e verificando se ela está correta e mantendo o usuario no menu
        //para não ser retirado e manter a verificação
        boolean nomeFornecedorCerto = false;

        while (!nomeFornecedorCerto) {

            try {

                System.out.println("Insira o seu nome: ");
                String nomeFornecedor = sc.nextLine();
                boolean situacao = false;
                if (!situacao) {
                    fornecedor.setNomeFornecedor(nomeFornecedor);
                    nomeFornecedorCerto = true;

                } else {
                    System.out.println("Fornecedor existente");
                    return;
                }
            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }
        }

        boolean cpfOucnpfCerto = false;

        while (!cpfOucnpfCerto) {
            try {

                System.out.println("Possui CPF ou CNPJ? ");
                System.out.println("1 - CPF");
                System.out.println("2 - CNPJ");
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Insira o CPF: ");
                        String cpf = sc.nextLine();
                        fornecedor.setCpfOucnpjFornecedor(cpf);
                        cpfOucnpfCerto = true;
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Insira o CNPJ: ");
                        String cpnf = sc.nextLine();
                        fornecedor.setCpfOucnpjFornecedor(cpnf);
                        cpfOucnpfCerto = true;
                        break;

                    default:
                        System.out.println("Insira uma das opções acima");
                }

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }
        }

        boolean telefoneFornecedorCerto = false;
        while (!telefoneFornecedorCerto) {
            try {

                System.out.println("Insira seu telefone sem estar formatado");
                String telefone = sc.nextLine();
                fornecedor.setTelefoneFornecedor(telefone);
                telefoneFornecedorCerto = true;

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }
        }

        boolean emailFornecedorCerto = false;
        while (!emailFornecedorCerto) {

            try {

                System.out.println("Insira seu email");
                String email = sc.nextLine();
                fornecedor.setEmailFornecedor(email);
                emailFornecedorCerto = true;

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }
        }

        boolean enderecoFornecedorCerto = false;
        while (!enderecoFornecedorCerto) {
            try {

                System.out.println("Insira seu endereco");
                String endereco = sc.nextLine();
                fornecedor.setEnderecoFornecedor(endereco);
                enderecoFornecedorCerto = true;

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }
        }
    }

    //Menu produto
    public void menuProduto() {
        Scanner sc = new Scanner(System.in);
        //Criando um laço while para cada informação e verificando se ela está correta e mantendo o usuario no menu
        //para não ser retirado e manter a verificação
        boolean nomeFornecedorCerto = false;

        while (!nomeFornecedorCerto) {

            try {

                System.out.println("Insira o seu nome: ");
                String nomeFornecedor = sc.nextLine();
                boolean situacao = false;
                if (!situacao) {
                    fornecedor.setNomeFornecedor(nomeFornecedor);
                    //Guardando o fornecedor diretamente no objeto
                    nomeFornecedorCerto = true;
                } else {
                    System.out.println("Fornecedor existente");
                }
            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }
        }
        boolean nomeCerto = false;
        while (!nomeCerto) {
            try {

                System.out.println("Digite o nome do produto: ");
                String nomeProduto = sc.nextLine();
                produto.setNomeProduto(nomeProduto);
                nomeCerto = true;

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());

            }

        }

        boolean precoCerto = false;
        while (!precoCerto) {

            try {

                System.out.println("Digite o preço do produto: ");
                Double precoProduto = sc.nextDouble();
                produto.setPrecoProduto(precoProduto);
                precoCerto = true;
                sc.nextLine(); //Limpeza de buffer após inserir números

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());
                sc.nextLine(); //Descarta o texto/numero recebido e retorna null para novamente receber um número

            }
        }

        boolean quantidadeCerto = false;
        while (!quantidadeCerto) {

            try {

                System.out.println("Digite o quantidade do produto: ");
                Integer quantidadeProduto = sc.nextInt();
                //Atribuindo o valor de quantidade em ambos os sets
                produto.setQuantidadeProduto(quantidadeProduto);
                entradaItens.setQuantidade(quantidadeProduto);
                itensVenda.setQuantidade(quantidadeProduto);
                quantidadeCerto = true;
                sc.nextLine(); //Limpeza de buffer após inserir números

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());
                sc.nextLine(); //Descarta o texto/numero recebido e retorna null para novamente receber um número

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
                sc.nextLine(); // Limpeza de buffer do erro

            }
        }

        boolean precoProdutoOkay = false;
        while (!precoProdutoOkay) {

            try {

                System.out.println("Digite o preço unitario do produto: ");
                Double precoProduto = sc.nextDouble();
                entradaItens.setPrecoUnitarioDosProdutos(precoProduto);
                itensVenda.setPrecoUnitario(precoProduto);
                precoProdutoOkay = true;
                sc.nextLine(); //Limpeza de buffer após inserir números

            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());
                sc.nextLine(); //Descarta o texto/numero recebido e retorna null para novamente receber um número

            }

        }

        boolean formaDePagamentoOkay = false;
        while (!formaDePagamentoOkay) {

            try {

                System.out.println("Digite o forma de pagamento: ");
                System.out.println(Situacao.FORMAS_PAGAMENTO.getMsgUser());
                System.out.println("1 - Dinheiro");
                System.out.println("2 - Cartão de Crédito");
                System.out.println("3 - Cartão de Débito");
                System.out.println("4 - Pix");

                int opcaoPagamento = sc.nextInt();

                switch (opcaoPagamento) {

                    //Atribuindo os Enum no objeto para ser atribuido ao banco de dados

                    case 1:

                        System.out.println("Dinheiro selecionado");
                        venda.setForma_pagamento(Metodo.Dinheiro);
                        formaDePagamentoOkay = true;
                        break;

                    case 2:

                        System.out.println("Cartão de credito selecionado");
                        venda.setForma_pagamento(Metodo.Cartao_Credito);
                        formaDePagamentoOkay = true;
                        break;

                    case 3:

                        System.out.println("Cartão de Débito selecionado");
                        venda.setForma_pagamento(Metodo.Cartao_Debito);
                        formaDePagamentoOkay = true;
                        break;

                    case 4:

                        System.out.println("Pix selecionado");
                        venda.setForma_pagamento(Metodo.Pix);
                        formaDePagamentoOkay = true;
                        break;

                    default:

                        System.out.println("Insira uma opção correta");

                }
            } catch (InputMismatchException e) {

                System.out.println(Situacao.RECUSADO.getMsgUser());
                sc.nextLine();

            }
        }
        //Todas as atribuições de dados para o MySQL
        produto.setFornecedor(fornecedor);
        entradaItens.setProduto(produto);
        //Calculando o valor e atribuindo ao objeto Venda
        Double valor = produto.getPrecoProduto() * entradaItens.getQuantidade();
        venda.setValor_total(valor);
        itensVenda.setSubtotal(valor);
        itensVenda.setProduto(produto);
        itensVenda.setVendas(venda);
    }
}
