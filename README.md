# ZTPAI-project — Wypożyczalnia szalunków i rusztowań

Projekt demo: prosta strona z ofertą oraz REST API do prezentacji produktów.

## Wybrane technologie
- Backend: **Java + Spring Boot**
- Frontend: **Vue 3 + Vite**

## Struktura projektu
```
backend/  - aplikacja Spring Boot (port 8080)
frontend/ - aplikacja Vue (Vite) (port 5173)
```

## Uruchomienie lokalne

### Backend
```
cd backend
mvn spring-boot:run
```
API dostępne pod: `http://localhost:8080/api/products`

Przykłady:
- Lista produktów: `curl http://localhost:8080/api/products`
- Produkt o id 1: `curl http://localhost:8080/api/products/1`
- Zły format id (400): `curl http://localhost:8080/api/products/abc`

### Frontend
```
cd frontend
npm install
npm run dev
```
Frontend domyślnie dostępny pod `http://localhost:5173`

## Commity (konwencja)
- `feat(api): add endpoint for products`
- `fix(routing): return 400 for invalid id param`
- `docs: update README`
