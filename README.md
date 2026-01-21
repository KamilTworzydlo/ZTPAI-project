# ZTPAI-project — Rental Management Demo

Projekt demonstracyjny wypożyczalni szalunków i rusztowań z backendem REST API (Spring Boot) oraz frontendem SPA (Vue 3 + Vite).
Celem projektu jest prezentacja CRUD, integracji frontend–backend oraz inicjalizacji bazy danych.

---

## 🚀 Funkcjonalności

### Backend (Spring Boot)
- CRUD dla produktów
- Walidacja parametrów (400 / 404)
- Inicjalizacja danych (`data.sql`)
- Dokumentacja API (Swagger)

### Frontend (Vue 3)
- Lista produktów
- Dodawanie produktu
- Usuwanie produktu
- Obsługa błędów

---

## 🛠 Technologie

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Vue 3
- Vite
- Swagger (springdoc-openapi)

---

## 📁 Struktura projektu

```
ZTPAI-project/
├── backend/     # Spring Boot REST API
├── frontend/    # Vue 3 + Vite
└── README.md
```

---

## ⚙️ Wymagania

- Java 17+
- Maven
- Node.js + npm

---

## ▶️ Uruchomienie

### Backend

```bash
cd backend
mvn clean spring-boot:run
```

API:
```
http://localhost:8080
```

Swagger:
```
http://localhost:8080/swagger-ui.html
```

---

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend:
```
http://localhost:5173
```

---

## 📌 Przykłady API

Pobranie listy produktów:
```bash
curl http://localhost:8080/api/products
```

Pobranie produktu:
```bash
curl http://localhost:8080/api/products/1
```

Błędny parametr:
```bash
curl http://localhost:8080/api/products/abc
```

---

## 🗃 Baza danych

- H2 (in-memory)
- Dane inicjalne w `data.sql`
- Kategorie i produkty ładowane przy starcie aplikacji

---

## 🧪 Testowanie

- Swagger UI
- curl / Postman
- Frontend UI

---
## Asynchroniczność
Aplikacja wykorzystuje mechanizm asynchronicznego przetwarzania zadań przy użyciu
adnotacji `@Async` w Spring Boot. Przykładowy endpoint:
POST `/api/async-test`, który uruchamia zadanie w tle bez blokowania wątku HTTP.

## Bezpieczeństwo
Aplikacja wykorzystuje mechanizm uwierzytelniania oparty o JWT (JSON Web Token).
Endpoint POST `/api/auth/login` generuje token JWT dla użytkownika, który następnie
jest wymagany do uzyskania dostępu do zabezpieczonych endpointów REST,
np. GET `/api/secure/test`.

## Dokumentacja API
Dokumentacja API dostępna jest poprzez Swagger UI:
http://localhost:8080/swagger-ui/index.html  
Swagger prezentuje wszystkie dostępne endpointy REST wraz z opisami oraz modelami danych.

## 🧩 Konwencja commitów

Projekt stosuje **Conventional Commits**:

```
feat(api): add product CRUD endpoints
fix(db): align entities with data.sql
fix(api): handle invalid id parameter
docs(readme): update project documentation
```

---


