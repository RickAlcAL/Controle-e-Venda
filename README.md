# Sistema de Controle de Estoque e Vendas integrado com Spring Boot com JPA (REFATORADO)

### Projeto criado de maneira gratuita e aprendizado

Foi utilizado o padrão MVC de organização de pastas de arquivos 
`OBS: 1 vez de utilização do MVC por mim`
* Métodos utilizados
* POO (Programação Orientada a Objeto), ORM(JPA)-Object-Relational
* Framework SpringBoot

>> Sistema foi refatorado sem interação com o Menu via java caso queira testar provavelmente não irá funcionar

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
* [documentationAPI_REST.html](src/main/resources/static/docs/documentationAPI_REST.html)
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
[db_vendas.sql](database/db_vendas.sql)  

### Observações

O sistema foi criado apenas para aprendizado de relacionamento de entidades do mysql com java, todo ou qualquer bug causado
via mysql, ou java não foi testado 

* Com este aprendizado estabelecido neste sistema será refeito e implementado ao Spring Boot
*  Projeto criado dentro da instituição SENAICTTIT

>Serviço de Aprendizado Industrial do Centro da Tecnologia da Informação

* O projeto possui DEV_LOGS documento o passo a passo do projeto

> Atenção: O projeto será adicionado com os arquivos: pom.xml, persistence.xml,application.properties

[DEV_log.md](DEV_log.md)



