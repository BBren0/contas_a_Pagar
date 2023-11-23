# **Api Contas a Pagar Spring Boot**

<h2>Objetivo da Plataforma:</h2>  
Este projeto visa desenvolver uma aplicação web dedicada ao gerenciamento e controle de despesas, tanto para uso pessoal quanto corporativo. Oferecendo recursos para registrar, modificar, remover e consultar despesas, a aplicação tem como propósito simplificar o acompanhamento financeiro, permitindo aos usuários uma visão organizada e clara de seus gastos.

<h2>Público-Alvo:</h2>    
Esta plataforma destina-se a indivíduos ou empresas que procuram uma solução prática e eficaz para controlar suas despesas. É útil para pessoas que desejam acompanhar suas finanças pessoais, assim como para equipes financeiras de organizações que precisam gerenciar despesas corporativas.

<h2>Tecnologias empregadas</h2>   

#### Linguagem de Programação: Java  
- O Java é uma escolha sólida para o desenvolvimento de aplicativos corporativos devido à sua robustez, portabilidade e ampla adoção na indústria. Sua orientação a objetos e forte suporte à comunidade fazem dele uma escolha popular para o desenvolvimento backend.  

#### Framework:Spring Boot  
- O Spring Boot, em particular, simplifica muito o processo de configuração e inicialização de aplicativos Spring, fornecendo padrões e facilidades para desenvolvimento rápido. Oferece injeção de dependência, segurança, web MVC, acesso a dados, entre outros.
-  
#### Banco de Dados: MySQL  
- O MySQL é um banco de dados relacional amplamente utilizado devido à sua confiabilidade, desempenho e comunidade ativa. É conhecido por ser fácil de usar e estável, sendo uma escolha comum para aplicativos web.

<h2>Facilitadores</h2>  

- **Lombok:** Utilizado para reduzir a verbosidade do código Java, gerando automaticamente métodos como getters, setters, construtores, etc., por meio de anotações.    

- **Jakarta Persistence (JPA) e Hibernate:** Permitem a persistência de objetos Java em bancos de dados relacionais. Simplificam a interação com o banco de dados através de mapeamento objeto-relacional.
  
- **Spring Data JPA:** Facilita a implementação de camadas de acesso a dados baseadas em JPA. Provê funcionalidades para realizar operações comuns de CRUD.  

<h2>Principais Funcionalidades</h2>    

- **Registro de Despesas:** Permite aos usuários adicionar novas despesas, inserindo informações como descrição, valor e data de vencimento.

- **Edição e Remoção de Despesas:** Capacidade de modificar e eliminar despesas previamente cadastradas.

- **Consulta e Listagem de Despesas:** Funcionalidade para visualizar todas as despesas registradas e buscar despesas específicas por descrição, valor, data e ID.

- **Filtragem e Ordenação:** Opção para filtrar despesas com base em critérios como descrição,  devalor mínimo, data vencimento, e ordenar os resultados de acordo com determinadas preferências.

- **Validações e Mensagens de Erro:** Implementação de validações para assegurar a integridade dos dados inseridos e exibição de mensagens claras em caso de erros ou informações incompletas.

- **Acesso Seguro:** Incorporação de medidas de segurança para garantir acesso autorizado e proteção dos dados dos usuários.

<h2>Arquitetura</h2>

`Controladores (DespesaController)`  
Responsável por lidar com as requisições HTTP, definindo endpoints e interagindo com os serviços para executar operações específicas.

`Modelos (Despesa, Mensagem)`  
Representam as entidades do domínio da aplicação.

Despesa: Contém atributos relacionados a uma despesa.
Mensagem: Utilizada para transmitir mensagens informativas ou de erro.

`Repositórios (DespesaRepository)`  
Interfaces que fornecem métodos para acessar e manipular dados no banco de dados para as entidades específicas (Despesa neste caso).
Realiza operações de busca, ordenação, filtragem e contagem sobre as despesas.

`Serviço (Servico)`  
Contém a lógica de negócios da aplicação.
Responsável por validar dados, executar operações específicas relacionadas às despesas e interagir com o repositório para persistir ou recuperar informações.

<h2>Conceitos de POO Demonstrados:</h2>

- **Abstração:** As classes representam entidades do mundo real (Despesa) e objetos com comportamentos específicos (Servico, Controladores) dentro do contexto da aplicação.

- **Encapsulamento:** Utilização de modificadores de acesso (private, public) para controlar o acesso aos membros das classes, como atributos e métodos.

<h2>Método CRUD (Create, Read, Update and Delete)</h2>

`Create:`  
É possível criar uma nova despesa utilizando o endpoint /contas_a_Pagar/despesa com os dados apropriados no corpo da requisição (descricao, valor, vencimento). A aplicação valida se a descrição não está vazia e se o valor é maior que zero antes de criar a despesa.

`Read:`  
Listagem de Despesas (GET): O endpoint /contas_a_Pagar retorna todas as despesas cadastradas.

`Update:`  
A operação de edição de despesa está disponível no endpoint /contas_a_Pagar/despesa/editar, permitindo a atualização dos dados de uma despesa existente. Realiza validações para garantir que o ID exista e que a descrição e o valor sejam válidos.

`Delete:`  
A operação de exclusão de despesa está acessível via /contas_a_Pagar/delete/{id} e remove a despesa com o ID especificado. A aplicação verifica se o ID existe antes de excluir a despesa.

<h2>Inovação e Criatividade</h2>

`Métodos de Consulta Personalizados:`  
A criação de métodos personalizados no DespesaRepository para consultas específicas, como filtrar por valor, ordenar por descrição e realizar consultas por caracteres ou início de descrição, demonstra um pensamento além do simples CRUD.

`Vínculo com banco de dados MySql:`  
O código tem um vínculo com o banco de dados relacional MySql, isso faz com que as nossas operações CRUD sejam refletidas no banco de dados através. As tabelas no código são representadas pela entidade @Entity que cria uma tabela no banco de dados.




<h2>Desenvolvedor:</h2>
<h5>- Breno Gabriel Viana Lopes- 202223250 </h5>
<h2> Professor Orientador:</h2>
<h5>- Prof. José Matias Lemes Filho</h5>
<h2>Matriz Curricular:</h2>
</h5>- Programação Orientada a Objetos</h5>
