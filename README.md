<h1 align="center"> 💻 Sobre o desafio </h1> 

<div align="center" > 
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    <img src="https://img.shields.io/badge/Insomnia-5849be?style=for-the-badge&logo=Insomnia&logoColor=white"/>
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
</div>

<br> 

```php 
Olá! Este é um desafio SpringBoot + JPA + H2 DATA BASE!
```

<i>
    
 * O objetivo é construir uma API para gerênciar ordens de serviços

 * O usuário se cadastra e seus dados ficam salvos

 * A aplicação deve receber uma nova ordem de serviço incluindo um tecnico responsavel e o cliente que solicitou a OS

 * Cada OS tem um status e prioridade

</i>
 
##

### ⌛ <i>Status do Desafio: **`Concluido`** ✔</i>
 
##
  
 ### 🚀 <i>Funcionalidades disponiveis</i>
 
 [✔] Cadastro de Cliente
 <br> 
 [✔] Listagem de Cliente
 <br> 
 [✔] Listagem de Cliente por id
 <br> 
 [✔] Alteração de Cliente por id
 <br> 
 [✔] Remoção de Cliente por id

 [✔] Cadastro de Tecnico
 <br> 
 [✔] Listagem de Tecnico
 <br> 
 [✔] Listagem de Tecnico por id
 <br> 
 [✔] Remoção de Tecnico por id
 
 [✔] Cadastro de OS
 <br> 
 [✔] Listagem de OS
 <br> 
 [✔] Listagem de OS por id
 <br> 
 [✔] Alteração de OS por id

## 🛠  <i>Serviços disponíveis</i> 

### 👨‍💻 <i>Cliente:</i>

```json
  "id": 4,
  "nome": "Mussun",
  "cpf": "598.508.200-80",
  "telefone": "(88) 98888-7777"
``` 

### 🙅‍♂️ <i>Tecnico:</i>

```json

  "id": 1,
  "nome": "Samuel Melo",
  "cpf": "002.671.010-23",
  "telefone": "(83) 99617-2418"
``` 

### 🚨 <i>Ordem de serviço:</i>

### 👉 <i>OS quando aberta:</i>

```json
  "id": 1,
  "dataAbertura": "04/08/2021 16:25",
  "dataFechamento": null,
  "prioridade": 2,
  "status": 1,
  "observacoes": "Acesso ao JIRA",
  "tecnico": 1,
  "cliente": 4
```

### 👈 <i>OS quando fechada:</i>

```json
  "id": 1,
  "dataAbertura": "04/08/2021 16:25",
  "dataFechamento": "04/08/2021 18:50",
  "prioridade": 2,
  "status": 2,
  "observacoes": "Acesso ao JIRA",
  "tecnico": 1,
  "cliente": 4
```

### 📑 <i> Prioridades e Status </i>
```java
public enum Prioridade {
  BAIXA(0, "BAIXA"),
  MEDIA(1, "MEDIA"),
  ALTA(2, "ALTA");
 }
  
public enum Status {
  ABERTO(0, "ABERTO"),
  ANDAMENTO(1, "ANDAMENTO"),
  ENCERRADO(2, "ENCERRADO");
  }
```

<br>

### 🎯 <i>Diagrama UML</i>
<img align="center" src="https://github.com/samuelalmeida95/serviceOrder-api/blob/main/diagrama.png"></img>

<br>

<p align="center">Feito com 💚 by Samuel Almeida</p>

<br>
<div align="right">
    <img src="https://img.shields.io/badge/STATUS-CONCLUIDO-<#2A69B2>.svg" align="left"/>
    <img src="https://img.shields.io/badge/JAVA-SPRING BOOT-<#12EAEA>.svg" align="rigth"/>
</div>
   

