# Controle e Venda

### Projeto criado de maneira gratuita baseado na demanda do mercado de trabalho

Foi utilizado o padrão MVC de organização de pastas de arquivos 

* Métodos utilizados
* POO (Programação Orientada a Objeto), ORM(JPA)-Object-Relational
* Framework SpringBoot

### Nova implementação

* Está sendo adicionado o Front-End agora neste projeto
* Está sendo 100% refeito 
* Erros de saido e entrada e refatorando detalhes pequenos

> Observação: Sistema está feito de maneira básica, futuramente sempre será modificado

<br>

# Comandos do Banco de Dados

* Comandos usados na criação do DB

`Clique no diretorio abaixo que irá direto para o arquivo em .sql do DB`

# Links de teste POSTMAN

* http://localhost:8080/produtos/adicionarProduto
* http://localhost:8080/produtos/listarProdutos
* http://localhost:8080/fornecedores/adicionarFornecedor
* http://localhost:8080/fornecedores/listarFornecedores
* http://localhost:8080/entrada/listandoEntrada
* http://localhost:8080/itensVenda/listarItensVendas
* http://localhost:8080/vendas/listarVendas

### Link da documentação da API
* (https://app.swaggerhub.com/apis-docs/senai-41e/API_Estoque/V1?view=uiDocs#/)
* >Abra no navegador ou selecione o icone do navegador desejado

Adicionar produto (Qualquer produto da sua preferência)
```json

{ 
  "nomeProduto": "Cadeira Pichau",
  "precoProduto": 300.00,
  "quantidadeProduto": 30,
  "fornecedor": {
    "id": 4
  }
}
```
Adicionar funcionário (Qualquer um da sua preferência)
```json
{
  "nomeFornecedor": "Pichau Informática",
  "cpfOucnpjFornecedor": "12.345.678/0001-99",
  "telefoneFornecedor": "(47) 3301-0100",
  "emailFornecedor": "contato@pichau.com.br",
  "enderecoFornecedor": "Rua Joinville, 1000 - Centro, Joinville - SC"
}
```
## Baixar o DB/Usar o DB
* Clique aqui para usar o db ---> [db_vendas.sql](database/db_vendas.sql)  


### Observações

O sistema foi criado apenas para aprendizado de relacionamento de entidades do mysql com java, todo ou qualquer bug causado
via mysql, ou java não foi testado 

* Com este aprendizado estabelecido neste sistema será refeito e implementado ao Spring Boot
*  Projeto criado dentro da instituição SENAICTTIT

>Serviço de Aprendizado Industrial do Centro da Tecnologia da Informação


>> Atenção: O projeto será adicionado com os arquivos: pom.xml, persistence.xml,application.properties




