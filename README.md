# Projeto Java — MySQL (JDBC) + Criação de Tabela

Pequena aplicação **CLI em Java** que demonstra **como conectar ao MySQL via JDBC** e **criar a tabela `usuarios`** automaticamente. Ao iniciar, o programa solicita uma confirmação no console e, ao prosseguir, executa o `CREATE TABLE`.

## Funcionalidades
- Conexão com banco MySQL usando **JDBC** (URL, usuário e senha configuráveis no código).
- Execução de **SQL de criação de tabela** (`usuarios`) com campos:
  - `id` INT **AUTO_INCREMENT** (PK)
  - `nome` VARCHAR(100) **NOT NULL**
  - `email` VARCHAR(100) **UNIQUE NOT NULL**
- Fluxo simples em modo texto: o app pede **“Digite 1 Para Conectar”** e realiza a operação.

## Pré‑requisitos
- **Java JDK 8+**
- **MySQL** instalado e em execução (padrão usado: `localhost:3306` e banco `test`).
- **MySQL Connector/J** (`mysql-connector-j.jar`) disponível no **classpath**.

## Configuração
No arquivo `App.java`, ajuste as credenciais conforme necessário:
```java
// Exemplo (arquivo App.java):
private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "";
```
Se desejar, altere o SQL da tabela no método que retorna a string do `CREATE TABLE`.

## Como executar
> As instruções abaixo assumem que o `mysql-connector-j.jar` está no diretório atual.

**Linux/macOS**
```bash
javac -cp mysql-connector-j.jar App.java
java -cp .:mysql-connector-j.jar App
```

**Windows (PowerShell/CMD)**
```bat
javac -cp mysql-connector-j.jar App.java
java -cp .;mysql-connector-j.jar App
```

No console, digite **1** quando solicitado para conectar e criar a tabela.

## Estrutura principal do código
- `App` (classe principal): lê a entrada do usuário e chama a conexão com a string SQL de criação da tabela.
- `ConexaoBD`: cria a conexão `DriverManager.getConnection(...)` e executa o `CREATE TABLE` com `Statement#executeUpdate(...)`.
