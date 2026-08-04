Verificar o pq o ID do fornecedor não está sendo buscado nas tabelas e não está sendo inserido

Data 31/07 as  16:37 -- Problema corrigido

Arrumar o por que após o 1 fluxo do sistema o 2 trava com datached

data 01/08 as 16:20

Logs acima podem ser descartadas

Troca feita de classe pai atualmente = Fornecedor

Data 01/08 as 23:50

Sistema refeito

Problemas atuais:Ao tentar adicionar serviços a tabela entrada é preciso buscar o ID de fornecedor e de Produto (Pesquisra sobre)

Feitos: Inserir na tabela produtos e funcionarios feita com sucesso, cada classe tem o seu service que insere os atributos no MySQL
Correção: Banco de dados atualizado == FORNECEDOR NÃO PERTENCE MAIS A ENTRADAS pois com o id do fornecedor em produto ja consegue-se achar o portador
Data 02/08 as 01:53

Sistema terminado e refatorado
Data 02/08 as 17:45

Sistema sendo refatorado no dia 04/08 as 13:14

Aprendizado : Utilizando padrão MVC de pastas e aperfeiçoando o springboot com jpa

As requisições HTTP como get,post ou delete ficam em Controller pois é a divsão de camada de pastas responsavel para o SpringBoot
Já a pasta Service é a responsabilidade de manipulação de dados e inserção para o mySQL
E a repository é onde acontece a conversa do banco de dados como insert select e delete