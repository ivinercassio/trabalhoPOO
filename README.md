# 🛍️ Sistema de Controle de Vendas (MVC)

Este repositório contém um sistema genérico para controle e gerenciamento de vendas, produtos e marcas. O projeto foi desenvolvido como atividade prática para a disciplina de **Programação Orientada a Objetos (POO)**.

A aplicação adota o padrão arquitetural **MVC (Model-View-Controller)** para separar as responsabilidades de interface, lógica de negócios e estruturação de dados.

---

## 📌 Recursos do Sistema

*   **Padrão MVC:** Organização clara de código separando dados, controle e apresentação.
*   **Gerenciamento de Produtos:** Cadastro de itens associados a marcas específicas.
*   **Fluxo de Caixa/Vendas:** Criação de vendas contendo múltiplos itens e controle de carrinho.
*   **Filtros Avançados:** Capacidade de buscar registros de vendas de forma dinâmica (ex: busca por data).

---

## 🧩 Estrutura do Projeto (Arquitetura MVC)

A árvore do diretório `src/` está modularizada de acordo com as camadas do padrão de projeto:

### 🎮 Control (Controladores)
Intermedeiam a comunicação entre a interface do usuário e as regras de negócio.
*   📄 `MarcaController.java`
*   📄 `ProdutoController.java`
*   📄 `VendaController.java`

### 📦 Model (Modelos de Dados)
Representam as entidades do sistema e encapsulam os dados.
*   📄 `Carrinho.java` - Agrupamento de itens selecionados para a venda.
*   📄 `Item.java` - Representação da quantidade e valor de um produto na venda.
*   📄 `Marca.java` - Atributos de identificação da marca do produto.
*   📄 `Produto.java` - Atributos e dados do produto (preço, nome, código).
*   📄 `Venda.java` - Estrutura que unifica o cliente, data, itens e valor total.

### 🖥️ View (Camada de Apresentação)
Responsável pelas interações visuais e menus com o usuário no terminal.
*   📄 `ItemView.java`
*   📄 `ProdutoView.java`
*   📄 `VendaView.java`
*   📄 `Sistema.java` - Menu centralizador do sistema.

### 🏁 Inicialização
*   📄 `App.java` - Ponto de entrada (`main`) que dispara a aplicação.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
*   **Java Development Kit (JDK)** 11 ou superior instalado.

### Execução pelo Terminal
1.  Clone este repositório:
    ```bash
    git clone https://github.com
    ```
2.  Acesse a pasta raiz do projeto:
    ```bash
    cd sistema_controle_vendas_poo
    ```
3.  Compile os arquivos fontes estruturados em pacotes:
    ```bash
    javac src/**/*.java -d bin/
    ```
4.  Execute a classe principal para iniciar o sistema:
    ```bash
    java -cp bin/ App
    ```

---

## 🛠️ Tecnologias Utilizadas

*   **Java** (Lógica de negócios e POO)
*   **Padrão de Projeto MVC**

---

## 👤 Autor

*   **Iviner Cássio** - [ivinercassio](https://github.com)
