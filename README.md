# 🛠️ Quebra Galho

**Quebra Galho** é uma API desenvolvida com o objetivo de conectar clientes a profissionais de diversos serviços residenciais, como eletricistas, pintores, encanadores e muito mais. O sistema fornece uma base sólida para futuras integrações com interfaces web ou mobile, promovendo praticidade, organização e valorização do trabalho local.

## 📌 Objetivo

Criar uma solução backend que permita o cadastro, gerenciamento e consulta de:
- Profissionais (vendedores) com múltiplas profissões
- Clientes e suas avaliações sobre os serviços recebidos
- Relacionamentos entre usuários, profissões e avaliações

---

## 🧱 Tecnologias Utilizadas

- ☕ **Java 21**
- 🌱 **Spring Boot**
- 🌐 **Spring Web**
- 🧾 **Spring Data JPA**
- 🧰 **Lombok**
- 🐬 **MySQL**
- 🔍 **Postman** (para testes de API)
- 🧠 **IntelliJ IDEA** (IDE)

---

## 🧩 Estrutura do Sistema

- `Usuario` é uma **classe abstrata** base que contém os dados comuns.
  - `Administrador`: acesso total ao sistema.
  - `Cliente`: pode avaliar vendedores.
  - `Vendedor`: possui uma ou mais **profissões**.
- Relação **muitos-para-muitos (N:N)** direta entre `Vendedor` e `Profissao`.
- `Cliente` realiza avaliações (`Avaliacao`) para `Vendedor` (relação **1:N**).

