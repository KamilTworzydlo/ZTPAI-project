# Opis bazy danych

Baza danych została zaprojektowana dla systemu wypożyczalni szalunków i rusztowań.
Model danych spełnia trzecią postać normalną (3NF).

## Encje
- CATEGORY – przechowuje kategorie produktów (np. szalunki ścienne).
- PRODUCT – przechowuje dane produktów wraz z ceną za dzień.
- CUSTOMER – dane klientów wypożyczających sprzęt.
- RENTAL – informacje o wypożyczeniach.
- RENTAL_ITEM – pozycje wypożyczenia (konkretne produkty i ilości).

## Normalizacja (3NF)
- Dane produktów i klientów są przechowywane tylko w jednej tabeli.
- Relacje pomiędzy encjami realizowane są przez klucze obce.
- Brak atrybutów zależnych przechodnio od klucza głównego.

## Dane testowe
Baza zawiera przykładowe dane testowe umożliwiające:
- testowanie listy produktów,
- symulację wypożyczeń,
- sprawdzanie relacji pomiędzy encjami.
