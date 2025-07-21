
# 📘 Documentação Técnica – Customer Management API

> Última atualização: 17/07/2025

---

## 📦 Instalação

Instruções para clonar o repositório, instalar dependências e rodar o projeto localmente.

```bash
# Clone o repositório
git clone https://github.com/KaduSR/customer-management-api.git

# Acesse o diretório
cd customer-management-api

# Instale as dependências
./mvnw install

# Rode o projeto
./mvnw spring-boot:run
```

---

## 🔗 Endpoints da API

Descreva aqui os endpoints REST disponíveis na API.

| Método | Rota                 | Descrição                    | Autenticação |
|--------|----------------------|------------------------------|--------------|
| GET    | `/customers`         | Listar todos os clientes     | ❌           |
| POST   | `/customers`         | Criar um novo cliente        | ✅           |
| GET    | `/customers/{id}`    | Buscar cliente por ID        | ✅           |
| PUT    | `/customers/{id}`    | Atualizar cliente por ID     | ✅           |
| DELETE | `/customers/{id}`    | Deletar cliente por ID       | ✅           |

> ✅ = Requer autenticação com JWT  
> ❌ = Acesso público

---

## 🔐 Segurança

Nesta seção você pode descrever como a segurança foi implementada:

- Autenticação baseada em JWT
- Spring Security configurado para proteger endpoints
- Exceções de segurança tratadas via filtros personalizados
- Políticas CORS

Checklist para preencher:
- [ ] Estratégia de autenticação
- [ ] Fluxo de login
- [ ] Configurações de segurança da aplicação

---

## 🚀 Deploy

Detalhe aqui como a aplicação é preparada para produção:

- Ferramenta: Docker ou Vercel ou EC2?
- Banco de dados: PostgreSQL (local/produção)
- Variáveis de ambiente sensíveis
- Pipeline de CI/CD (ex: GitHub Actions)

Exemplo (se estiver usando Docker):

```bash
# Build da imagem
docker build -t customer-api .

# Rodar o container
docker run -p 8080:8080 customer-api
```
