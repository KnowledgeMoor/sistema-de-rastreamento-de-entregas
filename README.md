# Sistema de Rastreamento de Entregas

Prova para o curso de tecnólogo em sistemas para internet na IFTM campus Uberlândia Centro.

## Funcionalidades Implementadas

### 1. Documentação com Swagger
- Documentação completa dos endpoints disponível em `/swagger-ui.html`
- Especificação OpenAPI 3.0 em `/v3/api-docs`

### 2. Tratamento de Erros Global
- `ControllerAdvice` para tratamento de erros
- Respostas padronizadas para:
  - `PacoteNaoEncontradoException` (HTTP 404 Not Found)
  - Métodos afetados:
    - `PUT /pacotes/{id}`
    - `GET /pacotes/{id}`

### 3. Consultas Personalizadas
- Busca de pacotes usando Query Creation:
  - `GET /pacotes?status={status}` - Busca por status
  - `GET /pacotes?destinatario={nome}` - Busca por destinatário

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- Spring Data JPA
- Swagger/OpenAPI
- H2 Database (embarcado)
- Lombok
