Desenvolvido como projeto final da disciplina de Banco de Dados II, do semestre 2025.1

# CinemaParadiso | Gestão Cinematográfica com Java Web

Este projeto é uma aplicação de gestão para cinemas, desenvolvida para automatizar o controle de funcionários, sessões e vendas de ingressos. A ferramenta utiliza tecnologias consolidadas para garantir alta performance e integridade de dados.

## Tecnologias Aplicadas
- **Java 11 & Jakarta EE 10**: Utilização das especificações modernas do ecossistema Java para web.
- **Maven**: Gerenciamento de dependências e automação de build.
- **MySQL & JDBC**: Persistência de dados utilizando o padrão **Connection Factory** para gerenciamento de sessões.
- **Front-end Dinâmico**: Interface construída com HTML5, CSS3 e **JavaScript Assíncrono (Fetch API)** para comunicação fluida com os Servlets.

## Arquitetura e Diferenciais Técnicos
- **Segurança (PreparedStatement)**: Todas as consultas ao banco de dados são parametrizadas para prevenir ataques de **SQL Injection**.
- **Gestão de Recursos**: Implementação de *Try-with-resources* para garantir o fechamento automático das conexões e evitar vazamentos de memória (memory leaks).
- **Camada de Banco de Dados**: O projeto integra-se a um esquema MySQL que utiliza **Triggers** e **Functions** para automação de regras de negócio complexas.
- **Sanitização de Dados**: Processamento de strings e uso de Regex para validação de integridade de entradas sensíveis, como CPF.

## Como Executar
1. Certifique-se de ter o **JDK 11** e o **Apache NetBeans** instalados.
2. Clone o repositório e importe o projeto como **Maven Project**.
3. Configure as credenciais do seu banco de dados local na classe `ConnectionFactory.java`.
4. Execute o build (`Clean and Build`) e rode o projeto em um servidor como o **Tomcat**.
