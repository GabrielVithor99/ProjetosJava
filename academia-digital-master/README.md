Academia Digital API
====================

📖 Sobre o projeto
------------------

Este projeto é uma API REST desenvolvida em **Spring Boot** para gerenciar uma academia digital. Ele permite o cadastro e gerenciamento de **Alunos**, **Personais**, **Avaliações Físicas** e **Matrículas**.

🚀 Tecnologias utilizadas
-------------------------

*   Java 17+
    
*   Spring Boot
    
*   Spring Data JPA
    
*   Hibernate
    
*   PostgreSQL
    
*   Lombok
    
*   Swagger (Springdoc OpenAPI) ➡️ Dependência adicionada para melhor visualização e documentação dos endpoints
    

⚙️ O que foi feito e conceitos aplicados
----------------------------------------

Neste projeto, foi desenvolvida uma API REST utilizando o framework Spring Boot para gerenciar os recursos de uma academia digital, como Alunos, Personais, Avaliações Físicas e Matrículas.

Foram aplicados diversos conceitos do Spring, entre eles:

*   **Injeção de Dependências:** O Spring gerencia os componentes e serviços da aplicação, promovendo baixo acoplamento e facilitando testes.
    
*   **Spring Data JPA:** Abstração do acesso a dados, facilitando operações CRUD com o banco PostgreSQL através de repositórios.
    
*   **Controle de Rotas REST:** Implementação dos endpoints REST para manipulação dos recursos, utilizando anotações como @RestController, @GetMapping, @PostMapping, @PutMapping e @DeleteMapping.
    
*   **Validação e Tratamento de Exceções:** Validações nos dados recebidos e tratamento adequado de erros para garantir a robustez da API.
    
*   **Documentação com Swagger (Springdoc OpenAPI):** Integração para gerar documentação interativa dos endpoints, facilitando o consumo da API.
    

### Interações no código

*   As requisições HTTP são recebidas pelos controllers, que delegam as operações para os serviços.
    
*   Os serviços contêm a lógica de negócio e interagem com os repositórios para acessar o banco de dados.
    
*   Os repositórios utilizam Spring Data JPA para realizar operações no banco PostgreSQL.
    
*   A documentação Swagger permite testar e visualizar os endpoints de forma interativa.
    

📘 Documentação da API com Swagger
----------------------------------

Com a dependência do **Springdoc OpenAPI**, a API possui documentação interativa.

*   **Swagger UI:** http://localhost:8081/[swagger-ui.html](https://swagger-ui.html)
    
*   **OpenAPI JSON:** http://localhost:8081/v3/api-docs
    

### Configuração opcional

Você pode personalizar título, descrição e versão da API criando uma classe de configuração:

```
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
    
        return new OpenAPI()
        .info(new Info()
        .title("Academia Digital API")
        .version("1.0")
        .description("Documentação da API da Academia Digital"));
    
        }
}
```

📑 Endpoints principais
-----------------------

### Alunos

*   POST /alunos → Criar aluno
    
*   GET /alunos/{id} → Buscar aluno por ID
    
*   GET /alunos → Listar todos os alunos
    
*   PUT /alunos/{id} → Atualizar aluno
    
*   DELETE /alunos/{id} → Deletar aluno
    

### Personais

*   POST /personais → Criar personal
    
*   GET /personais/{id} → Buscar personal por ID
    
*   GET /personais → Listar todos os personais
    
*   PUT /personais/{id} → Atualizar personal
    
*   DELETE /personais/{id} → Deletar personal
    
*   POST /personais/{personalId}/alunos/{alunoId} → Vincular aluno a personal
    

### Avaliações Físicas

*   POST /avaliacoes → Criar avaliação física vinculada a aluno
    
*   GET /avaliacoes/{id} → Buscar avaliação por ID
    
*   GET /avaliacoes → Listar todas as avaliações
    

### Matrículas

*   POST /matriculas → Criar matrícula vinculada a aluno
    
*   GET /matriculas/{id} → Buscar matrícula por ID
    
*   GET /matriculas → Listar todas as matrículas
    

✅ Conclusão
-----------

Com o Swagger integrado, a API agora possui uma interface gráfica para explorar e testar os endpoints de forma prática e intuitiva.
