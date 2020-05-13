# desafio
Desafio para avaliação de candidato

### Instruções para o desafio
- O candidato deverá criar um fork no git e criar uma branch com o nome e sobrenome do canditado(ex: desafio_Jose_Silva) para o desenvolvimento da atividade;
- O projeto deverá ser divido em dois pacotes, um do front-end e um do back-end;
- O front deverá ser feito em Vue.js e o back deverá ser feito com spring boot;
- Fica a critério do candidato a implementar testes unitários;
- Histórico de commit será levado em consideração para acompanhamento da evolução do desafio, onde iremos avaliar o passo a passo desde a criação do projeto, criação dos pacotes back e front, criação dos serviços, criação das funcionalidades, etc. Portanto sugerimos que a cada passo realizado seja feito um commit com um comentário explicativo do que foi realizado, exemplo:
    - Commit 1- Criação da estrutura inicial do projeto;
    - Commit 2- Criação do pacote back-end;
    - Commit 3- Criação do pacote front-end;
    - Commit 4- Criação das entidades de persistência;
    - Commit x- Criação da funcionalidade Criar Licitação;
- Ao final do desafio, criar um documento explicando como configurar e subir a aplicação;


### Desafio
- Desenvolver uma aplicação web responsável por classificar as propostas de uma licitação.
- Licitação
    - Deve conter os atributos
        - descrição (string)
        - tipo classificação (enum ["Menor Preço", "Nota Preço"])
	- Incluir, excluir, atualizar

- Proposta
    - Deve conter os atributos
        - fornecedor (string)
        - nota (bigdecimal) somente para tipo NOTA_PRECO
        - preço (bigdecimal)
        - data cadastro (string)
        - classificação (integer)
        - licitação (objeto)
	- Incluir, excluir, atualizar, classificar

- Regras de classificação
    - Para licitações do tipo "Nota Preço" classificar a colocação pela nota, preço e data cadastro
        ``` markdown
        Fornecedor A, nota 8.0, preço 110.00, data 23/10/2019 10:00
        Fornecedor B, nota 8.0, preço 110.00, data 23/10/2019 10:30
        Fornecedor C, nota 8.9, preço 115.00, data 23/10/2019 10:40
        Fornecedor D, nota 7.5, preço 90.00, data 23/10/2019 10:50
        A ordem de classificação: Fornecedor C, Fornecedor A e Fornecedor B, Fornecedor D
        ```
    - Para licitações do tipo "Menor Preço" classificar a colocação pelo preço e data cadastro
        ``` markdown
        Fornecedor A, preço 115.00, data 23/10/2019 10:00
        Fornecedor B, preço 115.00, data 23/10/2019 10:30
        Fornecedor C, preço 100.00, data 23/10/2019 10:40
        A ordem de classificação: Fornecedor C, Fornecedor A e Fornecedor B
