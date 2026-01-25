# ZTPAI-project --- Rental Management System

Projekt demonstracyjny wypożyczalni szalunków i rusztowań z backendem
REST API (Spring Boot) oraz frontendem SPA (Vue 3 + Vite).\
Celem projektu jest prezentacja architektury warstwowej, CRUD,
autentykacji JWT oraz integracji frontend--backend.

------------------------------------------------------------------------

## 📌 Project Overview

Aplikacja umożliwia: - przegląd oferty produktów (szalunki,
rusztowania), - wysyłanie zapytań przez formularz kontaktowy, -
logowanie użytkownika z wykorzystaniem JWT, - zarządzanie danymi przez
REST API.

Projekt jest aplikacją typu **end-to-end**.

------------------------------------------------------------------------

## 🧱 Tech Stack

### Backend

-   Java 17\
-   Spring Boot 3\
-   Spring Security + JWT\
-   Spring Data JPA\
-   H2 (in-memory database)\
-   Swagger / OpenAPI

### Frontend

-   Vue 3 (Composition API)\
-   Vite\
-   Fetch API\
-   HTML / CSS (custom UI)

------------------------------------------------------------------------

## 🚀 Features

### Backend

-   CRUD produktów (`/api/products`)
-   Logowanie (`/api/auth/login`)
-   JWT
-   Formularz kontaktowy (`/api/contact`)
-   Endpoint asynchroniczny (`/api/async-test`)
-   Swagger

### Frontend

-   Home
-   Produkty
-   Modal zapytania
-   Login JWT
-   Integracja z backendem

------------------------------------------------------------------------

## 🔐 Authentication (JWT)

POST /api/auth/login

``` json
{
  "username": "admin",
  "password": "admin"
}
```

Response:

``` json
{
  "username": "admin",
  "token": "JWT_TOKEN"
}
```

------------------------------------------------------------------------

## 📄 API Documentation

http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------

## 🗄️ Database

H2 in-memory.\
Plik inicjalizujący:

backend/src/main/resources/data.sql

30 produktów testowych.

H2 console: http://localhost:8080/h2\
jdbc:h2:mem:testdb

------------------------------------------------------------------------

## ▶️ How to run

### Backend

``` bash
cd backend
mvn spring-boot:run
```

### Frontend

``` bash
cd frontend
npm install
npm run dev
```

------------------------------------------------------------------------

## 🧩 Architecture

controller -\> service -\> repository -\> model -\> dto

------------------------------------------------------------------------

## 🧪 Evaluation checklist

-   [x] README
-   [x] 30 rekordów w bazie
-   [x] CRUD
-   [x] JWT
-   [x] Formularz kontaktowy
-   [x] Frontend + backend
-   [x] Swagger
-   [x] UI/UX
-   [x] Git

------------------------------------------------------------------------

## 👤 Author

Kamil Tworzydło
