# Controle de Despesas - Estratégia de Construção do Sistema
## Índice
1. [Descrição](#descrição)
2. [Funcionalidades](#funcionalidades)
    - [Classe `Despesa`](#classe-despesa)
    - [Classe `TipoDespesa`](#classe-tipodespesa)
    - [Classe `Usuario`](#classe-usuario)
    - [Classe `DespesaManager`](#classe-despesamanager)
    - [Classe `TipoDespesaManager`](#classe-tipodespesamanager)
    - [Classe `UsuarioManager`](#classe-usuariomanager)
    - [Classe `SistemaControleDespesas`](#classe-sistemacontroledespesas)
3. [Requisitos](#requisitos)
4. [Como Executar](#como-executar)
5. [Contribuições](#contribuicoes)
6. [Licença](#licenca)
## Descrição
O sistema de Controle de Despesas é uma aplicação desenvolvida em Java que permite o gerenciamento de despesas, tipos de despesa e usuários. O sistema usa uma abordagem de Programação Orientada a Objetos (POO) para modelar as diferentes entidades e suas interações. Ele oferece funcionalidades para adicionar, listar, atualizar e excluir despesas, tipos de despesa e usuários. O sistema é projetado para ser extensível e modular, permitindo a fácil inclusão de novas funcionalidades no futuro.
## Funcionalidades
### Classe `Despesa`
A classe `Despesa` representa uma despesa financeira com os seguintes atributos e métodos:
#### Atributos:
- `descricao` (String): Descrição da despesa.
- `valor` (double): Valor da despesa.
- `dataVencimento` (String): Data de vencimento da despesa.
- `paga` (boolean): Status que indica se a despesa foi paga.
#### Métodos:
- **Construtor**: `Despesa(String descricao, double valor, String dataVencimento)` - Inicializa uma nova despesa com a descrição, valor e data de vencimento fornecidos. Inicialmente, a despesa não é paga.
- **anotarPagamento(double valorPago, String dataPagamento)**: Anota o pagamento da despesa se o valor pago for suficiente. Marca a despesa como paga.
- **isPaga()**: Retorna o status de pagamento da despesa.
### Classe `TipoDespesa`
A classe `TipoDespesa` define um tipo de despesa, permitindo categorizar as despesas.
#### Atributos:
- `id` (int): Identificador único do tipo de despesa.
- `nome` (String): Nome do tipo de despesa.
#### Métodos:
- **Construtor**: `TipoDespesa(String nome)` - Inicializa um novo tipo de despesa com o nome fornecido e atribui um identificador único.
- **getNome()**: Retorna o nome do tipo de despesa.
- **getId()**: Retorna o identificador do tipo de despesa.
### Classe `Usuario`
A classe `Usuario` representa um usuário do sistema, com gerenciamento de credenciais seguras.
#### Atributos:
- `login` (String): Nome de usuário para autenticação.
- `senha` (String): Senha do usuário, armazenada de forma criptografada.
#### Métodos:
- **Construtor**: `Usuario(String login, String senha)` - Inicializa um novo usuário com login e senha, criptografando a senha usando SHA-256.
- **encryptPassword(String senha)**: Criptografa a senha fornecida usando o algoritmo SHA-256.
### Classe `DespesaManager`
A classe `DespesaManager` gerencia a coleção de despesas, permitindo operações CRUD.
#### Atributos:
- `despesas` (List<Despesa>): Lista que armazena as despesas.
#### Métodos:
- **adicionarDespesa(Despesa despesa)**: Adiciona uma nova despesa à lista.
- **listarDespesas(boolean apenasPagas)**: Retorna uma lista de despesas filtradas com base no status de pagamento.
- **atualizarDespesa(int index, Despesa novaDespesa)**: Atualiza uma despesa existente com uma nova despesa na posição fornecida.
- **excluirDespesa(int index)**: Remove uma despesa da lista na posição fornecida.
### Classe `TipoDespesaManager`
A classe `TipoDespesaManager` gerencia os tipos de despesa, permitindo operações CRUD.
#### Atributos:
- `tiposDespesa` (List<TipoDespesa>): Lista que armazena os tipos de despesa.
#### Métodos:
- **adicionarTipoDespesa(TipoDespesa tipo)**: Adiciona um novo tipo de despesa à lista.
- **listarTiposDespesa()**: Retorna a lista de tipos de despesa.
- **atualizarTipoDespesa(int index, TipoDespesa novoTipo)**: Atualiza um tipo de despesa existente na posição fornecida.
- **excluirTipoDespesa(int index)**: Remove um tipo de despesa da lista na posição fornecida.
### Classe `UsuarioManager`
A classe `UsuarioManager` gerencia a coleção de usuários, permitindo operações CRUD.
#### Atributos:
- `usuarios` (List<Usuario>): Lista que armazena os usuários.
#### Métodos:
- **adicionarUsuario(Usuario usuario)**: Adiciona um novo usuário à lista.
- **listarUsuarios()**: Retorna a lista de usuários.
- **atualizarUsuario(int index, Usuario novoUsuario)**: Atualiza um usuário existente na posição fornecida.
- **excluirUsuario(int index)**: Remove um usuário da lista na posição fornecida.
### Classe `SistemaControleDespesas`
A classe `SistemaControleDespesas` é a interface principal que permite ao usuário interagir com o sistema através de um menu de opções.
#### Métodos:
- **menuPrincipal()**: Exibe o menu principal e gerencia as opções escolhidas pelo usuário, permitindo operações de CRUD para despesas, tipos de despesa e usuários.
- **gerenciarTiposDespesa(Scanner scanner)**: Submenu para gerenciar tipos de despesa.
- **gerenciarUsuarios(Scanner scanner)**: Submenu para gerenciar usuários.
## Requisitos
- Java 11 ou superior.
- IDE para desenvolvimento Java, como IntelliJ IDEA ou Eclipse.
## Como Executar
1. Clone o repositório:
    ```bash
    git clone <URL do repositório>
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd <nome do diretório>
    ```
3. Compile e execute o programa:
    ```bash
    javac Main.java
    java Main
    ```
## Contribuições
Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Para contribuir, faça um fork deste repositório e envie um pull request com suas alterações.
## Licença
Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
