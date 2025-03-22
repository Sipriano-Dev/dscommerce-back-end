
# PROJETO: Sistema DSCommerce

Sua solução deverá seguir as seguintes especificações:<br>
Um pedido deve ser representado por um objeto conforme projeto abaixo:<br>
<p align = center>
<a href="https://ibb.co/BP6LpNL"><img src="https://i.ibb.co/QcH9gd9/image-2024-07-07-T19-33-34-381-Z.png" alt="image-2024-07-07-T19-33-34-381-Z" border="0"></a>
</p>

O projeto foi desenvolvido na aula do curso Java Spring Professional - Capítulo: "API REST, camadas, CRUD, exceções, validações" da plataforma DEVSuperior do professor Nélio Alves.

> ## Principais Tecnologias

- <img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" title = "Java" /> Java 21 : Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- <img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original-wordmark.svg" title = "Spring boot"/> Spring Boot 3 : Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- <img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original-wordmark.svg" title = "Spring Data JPA"/>  Spring Data JPA: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- <img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sqldeveloper/sqldeveloper-original.svg" title = "H2 Database"/> H2 Database: Banco de dados SQL em memória.
- <img width="100px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-plain-wordmark.svg" /> Postman: Para testar os métodos http do controller.
> ## 1. Premissas
Deseja-se fazer um sistema para ser utilizado em cursos da Devsuperior no processo de aprendizado dos alunos. Para isto, a concepção do sistema partiu das seguintes
premissas:
- Deve ser um sistema que possua um modelo de domínio relativamente simples, porém abrangente, ou seja, que explore vários tipos de relacionamentos entre as
entidades de negócio (muitos-para-um, muitos-para-muitos, etc.).
- O sistema deve possibilitar a aplicação de vários conhecimentos importantes das disciplinas de fundamentos.
- O sistema deve conter as principais funcionalidades que se espera de um profissional iniciante deve saber construir, tais como telas de cadastro e fluxos de
caso de uso.

> ## 2. Visão geral do sistema

O sistema deve manter um cadastro de usuário, produtos e suas categorias. Cada
usuário possui nome, email, telefone, data de nascimento e uma senha de acesso. Os
dados dos produtos são: nome, descrição, preço e imagem. O sistema deve apresentar
um catálogo de produtos, os quais podem ser filtrados pelo nome do produto. A partir
desse catálogo, o usuário pode selecionar um produto para ver seus detalhes e para
decidir se o adiciona a um carrinho de compras. O usuário pode incluir e remover itens
do carrinho de compra, bem como alterar as quantidades de cada item. Uma vez que o
usuário decida encerrar o pedido, o pedido deve então ser salvo no sistema com o status
de "aguardando pagamento". Os dados de um pedido são: instante em que ele foi salvo,
status, e uma lista de itens, onde cada item se refere a um produto e sua quantidade no
pedido. O status de um pedido pode ser: aguardando pagamento, pago, enviado,
entregue e cancelado. Quando o usuário paga por um pedido, o instante do pagamento
deve ser registrado. Os usuários do sistema podem ser clientes ou administradores,
sendo que todo usuário cadastrado por padrão é cliente. Usuários não identificados
podem se cadastrar no sistema, navegar no catálogo de produtos e no carrinho de
compras. Clientes podem atualizar seu cadastro no sistema, registrar pedidos e visualizar
seus próprios pedidos. Usuários administradores tem acesso à área administrativa onde
pode acessar os cadastros de usuários, produtos e categorias.

> ## 3. Protótipos de tela:

https://www.figma.com/file/ZrGNVNG0kZL6txDv4G8P6s/DSCommerce

> ## 4. Modelo conceitual

Este é o modelo conceitual do sistema DSCommerce. Considerações:

- Cada item de pedido (OrderItem) corresponde a um produto no pedido, com uma quantidade. Sendo que o preço também é armazenado no item de pedido por
questões de histórico (se o preço do produto mudar no futuro, o preço do item de pedido continua registrado com o preço real que foi vendido na época).
- Um usuário pode ter um ou mais "roles", que são os perfis de acesso deste usuário no sistema (client, admin).
<br><br>
<p align = center>
<a href="https://ibb.co/BP6LpNL"><img src="https://i.ibb.co/QcH9gd9/image-2024-07-07-T19-33-34-381-Z.png" alt="image-2024-07-07-T19-33-34-381-Z" border="0"></a>
</p>

> ## 5. Casos de uso (visão geral)

O escopo funcional do sistema consiste nos seguintes casos de uso:

<table>
  <thead>
    <tr align="left">
      <th>Caso de uso</th>
      <th>Visão geral</th>
      <th>Acesso</th>
    </tr>
  </thead>
  <tbody align="left">
    <tr><td>Manter produtos</td><td> CRUD de produtos, podendo filtrar itens pelo nome</td><td> Somente Admin</td></tr>
 <tr><td>Manter categorias</td><td> CRUD de categorias, podendo filtrar itens pelo nome</td><td> Somente Admin</td></tr>
 <tr><td>Manter usuários</td><td> CRUD de usuários, podendo filtrar itens pelo nome</td><td> Somente Admin</td></tr>
 <tr><td>Gerenciar carrinho</td><td> Incluir e remover itens do carrinho de compras, bem
como alterar as quantidades do produto em cada
item</td><td>Público</td></tr>
 <tr><td>Consultar catálogo</td><td> Listar produtos disponíveis, podendo filtrar produtos pelo nome</td><td>Público</td></tr>
 <tr><td>Sign up</td><td> Cadastrar-se no sistema</td><td> Público</td></tr>
 <tr><td>Login</td><td> Efetuar login no sistema</td><td> Público</td></tr>
 <tr><td>Registrar pedido</td> <td>Salvar no sistema um pedido a partir dos dados do carrinho de compras informado</td><td>Usuário logado</td></tr>
 <tr><td>Atualizar perfil</td><td>  Atualizar o próprio cadastro</td><td>  Usuário logado</td>
 <tr><td>Visualizar pedidos</td><td>  Visualizar os pedidos que o próprio usuário já fez</td><td>  Usuário logado</td>
 <tr><td>Registrar pagamento</td><td>  Salvar no sistema os dados do pagamento de um
pedido</td><td> 
Somente Admin</td>
 <tr><td>Reportar pedidos</td><td>  Relatório de pedidos, podendo ser filtrados por data</td><td>  Somente Admin</td>   
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>
<p align = center>
<a href="https://ibb.co/vZdY5Q5"><img src="https://i.ibb.co/r4psPcP/image-2024-07-11-T15-54-21-032-Z.png" alt="image-2024-07-11-T15-54-21-032-Z" border="0"></a>
</p>

### Atores

<table>
  <tbody align="left">
   <tr><td>Ator</td><td> Responsabilidade
 <tr><td>Usuário anônimo</td><td> Pode realizar casos de uso das áreas públicas do sistema, como
catálogo, carrinho de compras, login e sign up.</td></tr>
 <tr><td>Cliente</td><td> Responsável por manter seu próprios dados pessoais no sistema,
e pode visualizar histórico dos seus pedidos. Todo usuário
cadastrado por padrão é um Cliente.</td></tr>
 <tr><td>Admin</td><td> Responsável por acessar a área administrativa do sistema com
cadastros e relatórios. Admin também pode fazer tudo que
Cliente faz.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

> ## 6. Casos de uso (detalhamento)

<b>Consultar catálogo</b>
<table>
  <tbody align="left">
   <tr><td>Atores</td><td> Usuário anônimo, Cliente, Admin</td></tr>
<tr><td>Precondições</td><td> -</td></tr>
<tr><td>Pós-condições</td><td> -</td></tr>
<tr><td>Visão geral</td><td> Listar produtos disponíveis, podendo filtrar produtos pelo nome</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. [OUT] O sistema informa uma listagem paginada de nome, imagem e preço dos
produtos, ordenada por nome.</td></tr>
<tr><td>2. [IN] O usuário informa, opcionalmente, parte do nome de um produto</td></tr>
<tr><td>3. [OUT] O sistema informa a listagem atualizada</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

<br><br>


<table>
  <tbody align="left">
<tr><td>Informações complementares</td></tr>
<tr><td>O número padrão de registros por página deve ser 12. Como a listagem é paginada, o
usuário pode navegar nas próximas páginas.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>
<b>Manter produtos</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Admin</td></tr>
<tr><td>Precondições</td><td> Usuário logado</td></tr>
<tr><td>Pós-condições </td><td>-</td></tr>
<tr><td>Visão geral</td><td> CRUD de produtos, podendo filtrar itens pelo nome</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>

<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. Executar caso de uso: Consultar catálogo.<br>
2. O admin seleciona uma das opções<br>
    -  2.1. Variante Inserir<br>
    -  2.2. Variante Atualizar<br>
    -  2.3. Variante Deletar<br>
</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>
<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: variantes</td></tr>
<tr><td>2.1. Variante Inserir<br>
2.1.1. [IN] O admin informa nome, preço, descrição e URL da imagem e categorias do
produto.<br><br>
2.2. Variante Atualizar<br>
2.2.1. [IN] O admin seleciona um produto para editar.<br>
2.2.2. [OUT] O sistema informa nome, preço, descrição, URL da imagem e categorias do
produto selecionado.<br>
2.2.3. [IN] O admin informa novos valores para nome, preço, descrição, URL da imagem
e categorias do produto selecionado.<br><br>
2.3. Variante Deletar<br>
2.3.1. [IN] O admin seleciona um produto para deletar.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

<br>
<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: exceções</td></tr>
<tr><td>2.1.1a. Dados inválidos<br>
2.1.1a.1. [OUT] O sistema informa os erros nos campos inválidos [1].<br>
2.1.1a.2. Vai para passo 2.1.1.<br><br>
2.2.3a. Dados inválidos<br>
2.2.3a.1. [OUT] O sistema informa os erros nos campos inválidos [1].<br>
2.2.3a.2. Vai para passo 2.2.1.<br><br>
2.2.3b. Id não encontrado<br>
2.2.3b.1. [OUT] O sistema informa que o id não existe.<br>
2.2.3b.2. Vai para passo 2.2.1.<br><br>
2.3.1a. Id não encontrado<br>
2.3.1a.1. [OUT] O sistema informa que o id não existe.<br>
2.3.1a.2. Vai para passo 2.3.1.<br><br>
2.3.1b. Integridade referencial violada<br>
2.3.1b.1. [OUT] O sistema informa que a deleção não pode ser feita porque viola a
integridade referencial dos dados.<br>
2.3.1b.2. Vai para passo 2.3.1.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

<br>
<table>
  <tbody align="left">
<tr><td>Informações complementares</td></tr>
<tr><td>[1] Validação dos dados:<br>
- Nome: deve ter entre 3 e 80 caracteres<br>
- Preço: deve ser positivo<br>
- Descrição: não pode ter menos que 10 caracteres<br>
- Deve haver pelo menos 1 categoria</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

<b>Login</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Usuário anônimo</td></tr>
<tr><td>Precondições</td><td> -</td></tr>
<tr><td>Pós-condições</td><td> Usuário logado</td></tr>
<tr><td>Visão geral</td><td> Efetuar login no sistema</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>
<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. [IN] O usuário anônimo informa suas credenciais (nome e senha).<br>
2. [OUT] O sistema informa um token válido.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br><br>
<table>
  <tbody align="left">
 <tr><td>Cenário alternativos: exceções</td></tr>
<tr><td>1a. Credenciais inválidas<br>
1a.1. [OUT] O sistema informa que as credenciais são inválidas.<br>
1a.2. Vai para passo 1.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>
<b>Gerenciar carrinho</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Usuário anônimo</td></tr>
<tr><td>Precondições</td><td> -</td></tr>
<tr><td>Pós-condições</td><td> -</td></tr>
<tr><td>Visão geral</td><td> Incluir e remover itens do carrinho de compras, bem como alterar
as quantidades do produto em cada item</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
<tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. Executar caso de uso: Consultar catálogo.<br>
2. [IN] O Usuário anônimo seleciona um produto.<br>
3. [OUT] O sistema informa nome, preço, descrição, imagem, e nomes das categorias
do produto selecionado.<br>
4. [IN] O Usuário anônimo informa que deseja adicionar o produto ao carrinho.<br>
5. [OUT] O sistema informa os dados do carrinho de compras [1].<br>
6. [IN] O Usuário anônimo informa, opcionalmente, que deseja incrementar ou
decrementar a quantidade de um item no carrinho de compras.<br>
7. [ OUT] O sistema informa os dados atualizados do carrinho de compras [1].</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

<table>
  <tbody align="left">
<tr><td>Informações complementares</td></tr>
<tr><td>[1] Dados do carrinho de compras:<br>
- lista de itens de carrinho<br>
- valor total do carrinho de compras<br>
Dados do item de carrinho:<br>
    - id do produto<br>
- nome do produto<br>
- preço do produto<br>
- quantidade<br>
- subtotal<br>
</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>

<br>
<b>Registrar pedido</b>
<table>
  <tbody align="left">
 <tr><td>Atores</td><td> Cliente</td></tr>
<tr><td>Precondições</td><td> - Usuário logado<br>
- Carrinho de compras não vazio</td></tr>
<tr><td>Pós-condições</td><td> Carrinho de compras vazio</td></tr>
<tr><td>Visão geral</td><td> Salvar no sistema um pedido a partir dos dados do carrinho de
compras informado.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>
<table>
  <tbody align="left">
 <tr><td>Cenário principal de sucesso</td></tr>
<tr><td>1. [IN] O cliente informa os dados do carrinho de compras [1].<br>
2. [OUT] O sistema informa os dados do carrinho de compras[1] e o id do pedido.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>
<table>
  
  <tbody align="left">
 <tr><td>Informações complementares</td></tr>
<tr><td>[1] Dados do carrinho de compras: vide caso de uso Gerenciar carrinho.</td></tr>
  </tbody>
  <tfoot></tfoot>
</table>
<br>

> ## Checklist: adicionar segurança ao projeto
### Modelo de dados User-Role

<p align = center>

<a href="https://ibb.co/BzwzH63"><img src="https://i.ibb.co/4mJmwSt/user-role.png" alt="user-role" border="0"></a><br /><a target='_blank' href='https://imgbb.com/'></a><br />
</p>

### Mapeamento N-N

```
@ManyToMany
@JoinTable(name = "tb_user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();
```


### Seed

```
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
```

### Dependências

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-test</artifactId>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-oauth2-authorization-server</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

### Valores de configuração

```
security.client-id=${CLIENT_ID:myclientid}
security.client-secret=${CLIENT_SECRET:myclientsecret}

security.jwt.duration=${JWT_DURATION:86400}

cors.origins=${CORS_ORIGINS:http://localhost:3000,http://localhost:5173}
```

### Checklist OAuth2 JWT password grant

- Implementação customizada do password grant
- Authorization server
- Resource server

### Fazer o controle de acesso por perfil e rota




### Checklist Spring security

- GrantedAuthority
- UserDetails
- UserDetailsService
- UsernameNotFoundException

### Controle de acesso por perfil e rota

```
@PreAuthorize("hasRole('ROLE_ADMIN')")

@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
```

### Salvando um pedido

```
{
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 5,
      "quantity": 1
    }
  ]
}
```
