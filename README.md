# 🏨 Sistema de Gestão para Hotel

Um projeto de API RESTful para gerenciar o cadastro de pessoas e seus check-ins em um hotel, calculando os custos de estadia.

## 📝 Descrição

Este projeto implementa uma API REST para gerenciar duas entidades principais:
1.  **Pessoa/Usuário**: Realiza o cadastro, consulta, atualização e exclusão de usuários.
2.  **Check-in**: Gerencia a entrada de um usuário no hotel, aplicando regras de negócio para calcular o valor da diária com base no uso da garagem.

A aplicação foi desenvolvida com o ecossistema Spring Boot e serve como um ótimo exemplo de uma API de CRUD com regras de negócio específicas.

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Data JPA**: Para persistência de dados.
-   **Maven**: Para gerenciamento de dependências.
-   **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento (pode ser substituído por outro, como PostgreSQL ou MySQL).
-   **Lombok**: Para reduzir código boilerplate.

## ✨ Funcionalidades

-   ✔️ **Gerenciamento de Usuários**: CRUD completo para usuários (Pessoas).
-   ✔️ **Busca de Usuários**: Pesquisa por nome ou documento.
-   ✔️ **Registro de Check-in**: Cria um novo registro de entrada para um usuário existente.
-   ✔️ **Cálculo de Diária**: Aplica regras de negócio para calcular o custo da estadia, incluindo adicionais por uso de garagem.
-   ✔️ **Consulta de Custo Total**: Retorna o valor total gasto por um usuário em todas as suas estadias.

## ⚙️ Como Executar o Projeto

### Pré-requisitos

-   Java Development Kit (JDK) 17 ou superior.
-   Maven 3.8 ou superior.
-   Sua IDE favorita (ex: IntelliJ IDEA, VS Code, Eclipse).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/felipe-gon/spring-crud.git](https://github.com/felipe-gon/spring-crud.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd spring-crud
    ```

3.  **Instale as dependências com o Maven:**
    ```bash
    mvn clean install
    ```

4.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

Após a execução, a API estará disponível em `http://localhost:8080`.

## ↔️ Endpoints da API

A seguir estão os endpoints disponíveis na aplicação, divididos por controller.

### Endpoints de Usuários (`/pessoas`)

| Método HTTP | Endpoint                       | Descrição                                         | Corpo da Requisição (Exemplo)                                    |
| :---------- | :----------------------------- | :------------------------------------------------ | :--------------------------------------------------------------- |
| `POST`      | `/pessoas/createUser`          | Cria um novo usuário.                             | `{ "nome": "João", "documento": "123456", "telefone": "99999" }` |
| `GET`       | `/pessoas/getUsers`            | Retorna a lista de todos os usuários cadastrados. | N/A                                                              |
| `GET`       | `/pessoas/getUserByName/{nome}`| Busca um usuário específico pelo nome.            | N/A                                                              |
| `GET`       | `/pessoas/getUserByDoc/{doc}`  | Busca um usuário específico pelo documento.       | N/A                                                              |
| `PUT`       | `/pessoas/{id}`                | Atualiza um usuário existente pelo ID.            | `{ "nome": "João Silva", "documento": "654321", "telefone": "88888" }` |
| `DELETE`    | `/pessoas/deleteUser`          | Deleta um usuário.                                | `{ "id": 1 }`                                                    |

### Endpoints de Check-in (`/checkin`)

| Método HTTP | Endpoint                       | Descrição                                                      | Corpo da Requisição (Exemplo)                                           |
| :---------- | :----------------------------- | :------------------------------------------------------------- | :---------------------------------------------------------------------- |
| `POST`      | `/checkin/newCheckin`          | Realiza um novo check-in para um usuário já cadastrado.        | `{ "pessoa": { "nome": "João" }, "adicionalVeiculo": true }`            |
| `GET`       | `/checkin/getTotalCost/{nome}` | Retorna o valor total gasto por um usuário em todos os seus check-ins. | N/A                                                                     |


## 👨‍💻 Autor

Desenvolvido por **Felipe Gonçalves**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/felipe-vieira4859/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/felipe-gon)