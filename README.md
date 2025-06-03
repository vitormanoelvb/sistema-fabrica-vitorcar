<h1 align="center">🏭 Sistema - Fábrica VitorCar 🚗</h1>

<p align="center">
  <strong>Projeto desenvolvido em Java com Programação Orientada a Objetos (POO)</strong><br>
  <strong>💡 Interface interativa via console utilizando o motor gráfico VM ENGINE DEVELOPMENT v1.5</strong>
</p>

---

## 📘 Descrição do Projeto

A **Fábrica VitorCar** é um sistema acadêmico para gestão de pessoas e veículos com foco em controle de menores de idade, manutenção veicular e funcionalidades administrativas. Utiliza persistência de dados via banco de dados MySQL e menus interativos no console. Ideal para aprendizado de Java, JDBC e POO.

---

## 🚀 Funcionalidades

### 👤 Cadastro de Pessoas
- CPF único com validação.
- Nome com verificação de caracteres válidos.
- Verificação e controle de idade.
- Cancelamento seguro com confirmação dupla.

### 🚗 Cadastro de Carros
- Vinculação de veículos a uma pessoa já cadastrada.
- Suporte para placas antigas (ABC1234) e Mercosul (BRA1A23).
- Cadastro de **menores com termo de autorização** assinado no console.
- Validação de modelo, ano e unicidade de placa.

### 🧾 Termo de Autorização
- Impressão automática no console com nome, CPF e data.
- Armazenamento seguro em memória e no banco.
- Cada responsável pode autorizar apenas **um único menor**.

### 🔧 Simulação de Manutenção
- Tipos disponíveis: revisão, troca de óleo, troca de pneu.
- Registro do histórico por placa.
- Exibição e confirmação antes da inclusão.

### 📄 Relatórios e Estatísticas
- Listagem completa de pessoas, menores e veículos.
- Exibição dos responsáveis legais.
- Média de idade dos usuários.
- Carro(s) mais antigo(s) com respectivo modelo e placa.

### 🔐 Área Administrativa
- Acesso com login seguro: `admin / 1234`.
- Estatísticas em tempo real.
- Listagem geral de dados.
- Exclusão com integração direta ao banco de dados (MySQL):
  - Remove a pessoa.
  - Remove veículos.
  - Remove responsáveis e termos, se aplicável.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Interface:** Console com menus formatados e interação de usuário
- **Banco de Dados:** MySQL 8+ com JDBC
- **Motor Gráfico:** VM ENGINE DEVELOPMENT (para visual estilizado e fluidez)

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40" alt="mysql logo" />
  <img src="VM Engine Logo.png" height="130" alt="VM Engine Logo" />
</div>

---

## 🧩 Estrutura de Classes

- `Pessoa`: representa o usuário com CPF, nome, idade e veículos associados.
- `Carro`: define o modelo, placa e ano de fabricação de um veículo.
- `PessoaDAO`: responsável por todas as operações no banco (inserção, exclusão, busca).
- `ConexaoBD`: gerencia a conexão com o banco de dados MySQL.
- `Fabrica`: classe principal com menus, lógica de cadastro e simulação.

---

## 🗃️ Banco de Dados

- **Tabelas**:
  - `pessoa` – Armazena os dados das pessoas.
  - `carro` – Veículos associados a pessoas via `id_pessoa`.
  - `termo_autorizacao` – Termo entre responsável e menor.

- **Regras**:
  - Cada CPF é único.
  - Um responsável pode autorizar **apenas um menor**.
  - A exclusão em cascata é controlada manualmente via DAO.

---

## 🎨 Interface do Console

- ASCII Art na abertura e encerramento.
- Transições suaves com `Thread.sleep()`.
- Menus centralizados com bordas.
- Confirmações, mensagens de erro e retorno ao menu.

---

## 👨‍💻 Autoria

- **Desenvolvedor**: Vitor Manoel Vidal Braz  
- **Curso**: Sistemas de Informação - UNIVALE  
- **Período**: 3º  
- **Disciplina**: Programação Orientada a Objetos (POO)  
- **Professor Orientador**: Vitor Silva Ribeiro

---

## 🔗 Repositórios e Contato

- 🔗 GitHub: [@vitormanoelvb](https://github.com/vitormanoelvb)
- 📁 Repositório: [Sistema Fábrica VitorCar](https://github.com/vitormanoelvb/sistema-fabrica-vitorcar)

---

## 📺 Créditos Visuais

```
 __      __ __  __     _____  __     _______ _______ __  __ 
 \ \    / /|  \/  |   / ____| \ \   / / ____|__   __|  \/  |
  \ \  / / | \  / |  | (___    \ \_/ / (___    | |  | \  / |
   \ \/ /  | |\/| |   \___ \    \   / \___ \   | |  | |\/| |
    \  /   | |  | |   ____) |    | |  ____) |  | |  | |  | |
     \/    |_|  |_|  |_____/     |_| |_____/   |_|  |_|  |_|
                        V M   S Y S T E M S                  
```

**🖥️ Motor gráfico de console: VM ENGINE DEVELOPMENT v1.5**

<div align="left">
  <img src="VM Engine V.png" height="130" alt="VM Engine V1.5" />
</div>

---

## ⚠️ Observações Finais

Este sistema é um projeto **didático** e não deve ser utilizado em ambientes de produção. Foi desenvolvido para fins acadêmicos, com foco em aprendizado de Java, POO, persistência com JDBC e interação via console.

---

###

  <img src="VM ENGINE SYSTEMS.png" width="100%" alt="VM Engine Systems" />
</div>

---
