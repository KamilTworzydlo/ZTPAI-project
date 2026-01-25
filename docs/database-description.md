# Opis bazy danych – Rental System

## Cel
Baza danych obsługuje system wypożyczalni szalunków i rusztowań, umożliwiając
zarządzanie użytkownikami, produktami, wypożyczeniami i płatnościami.

## Tabele

### users
Przechowuje dane użytkowników systemu.
- role: ADMIN / CLIENT

### category
Kategorie produktów (np. szalunki, rusztowania).

### product
Produkty dostępne do wypożyczenia.
Relacja N:1 z category.

### rental
Reprezentuje wypożyczenie dokonane przez użytkownika.
Relacja 1:N z users.

### rental_item
Tabela pośrednia realizująca relację N:M pomiędzy rental i product.

### payment
Płatność przypisana do konkretnego wypożyczenia (1:1).

### audit_log
Rejestr zdarzeń systemowych (log audytowy).

## Normalizacja
Baza spełnia trzecią postać normalną (3NF):
- brak redundancji danych,
- brak zależności przechodnich,
- każda kolumna zależy wyłącznie od klucza głównego.
