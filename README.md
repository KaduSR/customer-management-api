# 💼 customer-management-api

API RESTful para **cadastro, listagem, edição e exclusão de clientes**, desenvolvida com **Java 17, Spring Boot 3** e **PostgreSQL**. Projeto criado como parte do meu portfólio pessoal, com foco em boas práticas de arquitetura, validação, documentação Swagger e visão de escalabilidade.

---

## 🚀 Funcionalidades

- ✅ Cadastro de clientes
- 🔍 Listagem de todos os clientes
- ✏️ Atualização de dados de clientes
- ❌ Exclusão de clientes
- 📄 Documentação automática com Swagger (OpenAPI 3)
- 🧱 Estrutura em camadas (Controller, Service, Repository, DTO)

---

## 🛠 Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Bean Validation**
- **PostgreSQL**
- **Lombok**
- **Springdoc OpenAPI (Swagger UI)**
- **Docker** (em breve)
- **Testes com JUnit e Mockito** (em construção)

---

## 🧠 Modelo de dados (ERD)

A estrutura atual inclui as entidades:

```plaintext
Cliente (1) ------- (N) Endereco
Cliente (1) ------- (1) PlanoContratado

```
Mais detalhes no diagrama na pasta /docs.


## 📁 Estrutura do projeto
```bash
src/
├── controller
│   └── ClienteController.java
├── service
│   └── ClienteService.java
├── repository
│   └── ClienteRepository.java
├── dto
│   └── ClienteDTO.java
├── model
│   ├── Cliente.java
│   ├── Endereco.java
│   └── PlanoContratado.java
└── config
    └── SwaggerConfig.java (opcional)
```
## 📦 Como executar o projeto

```bash
# Clone o repositório
git clone https://github.com/KaduSR/customer-management-api.git
cd customer-management-api

# Execute com sua IDE (VS Code, IntelliJ) ou via terminal
./mvnw spring-boot:run
```

## 📍 Endpoints principais

```bash
GET    /api/clientes
GET    /api/clientes/{id}
POST   /api/clientes
PUT    /api/clientes/{id}
DELETE /api/clientes/{id}
```

  Acesse a documentação Swagger:
👉 http://localhost:8080/swagger-ui.html


## 📌 Status do projeto
✅ MVP do CRUD implementado<br/>
🚧 Endereços e Planos em desenvolvimento<br/>
🚀 Docker, segurança (JWT) e testes automatizados nas próximas versões<br/>



## 🧑‍💻 Autor
Feito com dedicação por Kadu Ribeiro<br/>
📚 Estudante de Engenharia de Software | Backend Java Developer | Embaixador DIO Campus

## ⭐ Contribua
Sinta-se à vontade para forkar e sugerir melhorias.
Se você gostou desse projeto, deixe uma ⭐ no repositório!

