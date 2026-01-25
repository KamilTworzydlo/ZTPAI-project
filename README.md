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

Projekt jest aplikacją typu **end-to-end**: frontend komunikuje się
bezpośrednio z backendem poprzez HTTP (JSON).

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
-   Autoryzacja JWT
-   Formularz kontaktowy (`/api/contact`)
-   Endpoint asynchroniczny (`/api/async-test`)
-   Dokumentacja API (Swagger)

### Frontend

-   Strona główna z ofertą
-   Widok listy produktów
-   Modal zapytania
-   Strona logowania (JWT)
-   Integracja z backendem

------------------------------------------------------------------------

## 🔐 Authentication (JWT)

Endpoint:

    POST /api/auth/login

Body:

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

Token JWT jest zapisywany w `localStorage` i wykorzystywany do
autoryzacji zapytań do chronionych endpointów.

------------------------------------------------------------------------

## 📄 API Documentation

Swagger dostępny pod:

    http://localhost:8080/swagger-ui/index.html

Pozwala testować wszystkie endpointy: - products - auth - contact -
async-test - secure-test

------------------------------------------------------------------------

## 🗄️ Database

Projekt wykorzystuje bazę danych **H2 (in-memory)**.

Dane inicjalizowane są przez:

    backend/src/main/resources/data.sql

Zawiera: - 3 kategorie - 6 klientów - 30 produktów testowych

H2 console:

    http://localhost:8080/h2
    JDBC URL: jdbc:h2:mem:testdb
    User: sa
    Password: (puste)

------------------------------------------------------------------------

## ▶️ How to run

### Backend

``` bash
cd backend
mvn spring-boot:run
```

Backend:

    http://localhost:8080

### Frontend

``` bash
cd frontend
npm install
npm run dev
```

Frontend:

    http://localhost:5173

------------------------------------------------------------------------

## 🧩 Architecture

Architektura warstwowa:

controller → service → repository → model → dto

Każda warstwa odpowiada za inny poziom odpowiedzialności: - controller:
HTTP - service: logika biznesowa - repository: baza danych

------------------------------------------------------------------------

## 🧪 Evaluation checklist (kryteria ewaluacji)

Projekt spełnia następujące kryteria:

### 1. README i uruchomienie

-   [x] Jasny opis projektu\
-   [x] Instrukcja backend\
-   [x] Instrukcja frontend

### 2. Architektura / ERD

-   [x] Architektura warstwowa\
-   [x] Min. 5 tabel (Product, Category, Customer, User, Contact)

### 3. Baza danych

-   [x] 3NF\
-   [x] Min. 30 rekordów testowych

### 4. Repozytorium Git

-   [x] Conventional Commits\
-   [x] Czytelna historia\
-   [x] \>40 commitów

### 5. Implementacja funkcji

-   [x] CRUD produktów\
-   [x] Formularz kontaktowy\
-   [x] JWT\
-   [x] Frontend--backend

### 6. Dobór technologii

-   [x] Nowoczesny stack\
-   [x] Opisany w README

### 7. Architektura kodu

-   [x] Warstwy logiczne\
-   [x] Brak logiki w kontrolerach

### 8. UX / UI

-   [x] Responsywność\
-   [x] Własne komponenty\
-   [x] Spójny design

### 9. Uwierzytelnianie i autoryzacja

-   [x] JWT\
-   [x] Token w frontend\
-   [x] Ochrona endpointów

### 10. API

-   [x] REST\
-   [x] Poprawne statusy HTTP

### 11. Frontend--API

-   [x] Realna integracja\
-   [x] Loading / error

### 12. Jakość kodu

-   [x] Brak duplikacji\
-   [x] Czytelne nazwy

### 13. Asynchroniczność

-   [x] `/api/async-test`

### 14. Dokumentacja API

-   [x] Swagger\
-   [x] Aktualna dokumentacja

------------------------------------------------------------------------

## 👤 Author

Kamil Tworzydło\
Projekt wykonany w ramach zajęć z ZTPAI.
