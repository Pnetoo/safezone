# 🌐 SafeZone – Sistema Inteligente de Alerta Climático

> Projeto desenvolvido para a disciplina de DOMAIN DRIVEN DESIGN USING JAVA – FIAP

## 📖 Descrição

**SafeZone** é um sistema inteligente de monitoramento climático que utiliza sensores IoT para detectar e alertar usuários sobre riscos como chuvas intensas, enchentes, deslizamentos, entre outros eventos ambientais críticos. O sistema fornece notificações personalizadas com base em localização e armazena todos os dados em um banco Oracle, possibilitando o acompanhamento em tempo real via API RESTful.

## 🧠 Objetivo

Oferecer uma plataforma confiável, acessível e personalizável que ajude cidadãos, empresas e órgãos públicos a se prepararem para eventos climáticos extremos, promovendo a segurança e a prevenção de desastres.

---

## 🚀 Funcionalidades

- ✅ Registro de sensores ambientais por região
- ✅ Cadastro de usuários e dados enviados por eles
- ✅ Geração de alertas climáticos com base nos sensores
- ✅ API RESTful completa com CRUD para todas as entidades
- ✅ Tratamento global de exceções
- ✅ Integração com banco Oracle
- ✅ Camada de negócios (BO) para lógica de alerta

---

## 🧱 Estrutura do Projeto

- **Model**: Entidades JPA (Usuario, Sensor, Alerta, Regiao, DadoUsuario)
- **DAO/Repository**: Interface com o banco usando Panache
- **Service**: Lógica CRUD e de negócio
- **BO**: Lógica intermediária (ex: regras para alertas)
- **Resource**: Endpoints RESTful
- **Exception**: Tratamento global com `@Provider`

---

## 🧩 Tecnologias Utilizadas

| Ferramenta      | Descrição                     |
|------------------|-------------------------------|
| Java 17          | Linguagem de programação      |
| Quarkus          | Framework Java ultraleve      |
| Oracle XE        | Banco de dados relacional     |
| Hibernate Panache| ORM simplificado              |
| Maven            | Gerenciador de dependências   |
| REST             | API com padrões RESTful       |
| Postman          | Testes de endpoints           |

---

## 💾 Configuração do Banco

> O projeto já vem com os dados de acesso incluídos para testes:

```java
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String username = "rm560262";
String password = "170804";
