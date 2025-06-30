# 🏨 Sistema de Gestão para Hotel

Um projeto de API RESTful para gerenciar o cadastro de pessoas e seus check-ins em um hotel, calculando os custos de estadia. **A aplicação é protegida utilizando o fluxo de autenticação OAuth 2.0 do Google.**

## 📝 Descrição

Este projeto implementa uma API REST para gerenciar duas entidades principais:
1.  **Pessoa/Usuário**: Realiza o cadastro, consulta, atualização e exclusão de usuários.
2.  **Check-in**: Gerencia a entrada de um usuário no hotel, aplicando regras de negócio para calcular o valor da diária.

A aplicação foi desenvolvida com o ecossistema Spring Boot e utiliza o **Spring Security** para garantir que apenas usuários autenticados possam acessar os recursos da API.

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Security**
-   **Spring Boot OAuth2 Client**
-   **Spring Data JPA**: Para persistência de dados.
-   **Maven**: Para gerenciamento de dependências.
-   **H2 Database**: Banco de dados em memória.
-   **Lombok**: Para reduzir código boilerplate.

## ✨ Funcionalidades

-   ✔️ **Autenticação Segura**: Utiliza o fluxo OAuth 2.0 do Google para autenticar usuários.
-   ✔️ **Gerenciamento de Usuários**: CRUD completo para usuários (Pessoas).
-   ✔️ **Busca de Usuários**: Pesquisa por nome ou documento.
-   ✔️ **Registro de Check-in**: Cria um novo registro de entrada para um usuário existente.
-   ✔️ **Cálculo de Diária**: Aplica regras de negócio para o custo da estadia.
-   ✔️ **Consulta de Custo Total**: Retorna o valor total gasto por um usuário.

## 🔐 Segurança e Autenticação

A API é protegida e requer autenticação para a maioria dos endpoints. O fluxo de autenticação funciona da seguinte maneira:

1.  Ao tentar acessar um endpoint protegido (ex: `GET /pessoas/getUsers`) sem estar logado, você será automaticamente redirecionado para a página de login do Google.
2.  Após fazer o login e autorizar a aplicação, você será redirecionado de volta para a aplicação, agora com uma sessão autenticada.
3.  Com a sessão ativa, você poderá fazer requisições para os endpoints protegidos.

## ⚙️ Como Executar o Projeto

### Pré-requisitos

-   Java Development Kit (JDK) 17 ou superior.
-   Maven 3.8 ou superior.
-   Uma conta Google para configurar as credenciais de autenticação.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/felipe-gon/spring-crud.git](https://github.com/felipe-gon/spring-crud.git)
    cd spring-crud
    ```

2.  **Configure as Credenciais OAuth 2.0 do Google:**
    > ⚠️ **Esta etapa é obrigatória.** A aplicação não iniciará sem as credenciais.

    -   Acesse o [Google Cloud Console](https://console.cloud.google.com/) e crie um novo projeto.
    -   No menu, vá para **"APIs e serviços" > "Tela de permissão OAuth"**, configure as informações solicitadas.
    -   Vá para **"APIs e serviços" > "Credenciais"**, clique em **"+ CRIAR CREDENCIAIS"** e selecione **"ID do cliente OAuth"**.
    -   Escolha **"Aplicativo da Web"** como tipo.
    -   Em **"URIs de redirecionamento autorizados"**, adicione a seguinte URL:
        ```
        http://localhost:8080/login/oauth2/code/google
        ```
    -   Copie o **`Client ID`** e o **`Client Secret`** gerados.

3.  **Defina as Variáveis de Ambiente:**
    A aplicação lê as credenciais do Google a partir de variáveis de ambiente para manter seus segredos fora do código. Configure as seguintes variáveis no seu sistema:

    * **No Linux/macOS:**
        ```bash
        export GOOGLE_CLIENT_ID="SEU_CLIENT_ID_AQUI"
        export GOOGLE_CLIENT_SECRET="SEU_CLIENT_SECRET_AQUI"
        ```

    * **No Windows (CMD):**
        ```bash
        set GOOGLE_CLIENT_ID=SEU_CLIENT_ID_AQUI
        set GOOGLE_CLIENT_SECRET=SEU_CLIENT_SECRET_AQUI
        ```

4.  **Instale as dependências e execute:**
    Com as credenciais configuradas, você pode executar a aplicação.
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

Após a execução, a API estará disponível em `http://localhost:8080`.

## ↔️ Endpoints da API

> A maioria dos endpoints abaixo são **protegidos**. Você precisa estar autenticado via Google para acessá-los.

### Endpoints de Usuários (`/pessoas`)

| Método HTTP | Endpoint                       | Descrição                                         | Protegido | Corpo da Requisição (Exemplo)                                    |
| :---------- | :----------------------------- | :------------------------------------------------ | :-------: | :--------------------------------------------------------------- |
| `POST`      | `/pessoas/createUser`          | Cria um novo usuário.                             |    **Não** | `{ "nome": "João", "documento": "123456", "telefone": "99999" }` |
| `GET`       | `/pessoas/getUsers`            | Retorna a lista de todos os usuários cadastrados. |    **Sim** | N/A                                                              |
| `GET`       | `/pessoas/getUserByName/{nome}`| Busca um usuário específico pelo nome.            |    **Sim** | N/A                                                              |
| `GET`       | `/pessoas/getUserByDoc/{doc}`  | Busca um usuário específico pelo documento.       |    **Sim** | N/A                                                              |
| `PUT`       | `/pessoas/{id}`                | Atualiza um usuário existente pelo ID.            |    **Sim** | `{ "nome": "João Silva", "documento": "654321", "telefone": "88888" }` |
| `DELETE`    | `/pessoas/deleteUser`          | Deleta um usuário.                                |    **Sim** | `{ "id": 1 }`                                                    |

### Endpoints de Check-in (`/checkin`)

| Método HTTP | Endpoint                       | Descrição                                                      | Protegido | Corpo da Requisição (Exemplo)                                           |
| :---------- | :----------------------------- | :------------------------------------------------------------- | :-------: | :---------------------------------------------------------------------- |
| `POST`      | `/checkin/newCheckin`          | Realiza um novo check-in para um usuário já cadastrado.        |    **Sim** | `{ "pessoa": { "nome": "João" }, "adicionalVeiculo": true }`            |
| `GET`       | `/checkin/getTotalCost/{nome}` | Retorna o valor total gasto por um usuário em todos os seus check-ins. |    **Sim** | N/A                                                                     |

## 👨‍💻 Autor

Desenvolvido por **Felipe Gonçalves**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/felipe-vieira4859/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/felipe-gon)