package com.ztpai.controller;

import com.ztpai.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    // Prosta "baza danych" w pamięci aplikacji (na potrzeby projektu)
    private static final Map<Integer, Product> PRODUCTS = new LinkedHashMap<>();

    // Dane testowe – spełniają wymaganie przykładowych danych
    static {
        PRODUCTS.put(1, new Product(1, "Szalunek ścienny 1m2", "Szalunek do ścian, stalowy", 20.0));
        PRODUCTS.put(2, new Product(2, "Rusztowanie modułowe", "Rusztowanie - 2m wysokości", 45.0));
        PRODUCTS.put(3, new Product(3, "Zestaw podpór", "Podpory regulowane", 10.0));
    }

    /**
     * GET /api/products
     * Zwraca listę wszystkich produktów.
     * - 200 OK, gdy lista nie jest pusta
     * - 204 NO CONTENT, gdy brak produktów
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        if (PRODUCTS.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(new ArrayList<>(PRODUCTS.values())); // 200
    }

    /**
     * GET /api/products/{id}
     * Zwraca pojedynczy produkt na podstawie identyfikatora.
     * - 200 OK – gdy produkt istnieje
     * - 404 NOT FOUND – gdy brak produktu
     * - 400 BAD REQUEST – gdy id nie jest liczbą
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String idStr) {
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // Niepoprawny format parametru ścieżki
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Bad request: id must be an integer"));
        }

        Product product = PRODUCTS.get(id);
        if (product == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Product not found"));
        }

        return ResponseEntity.ok(product);
    }

    /**
     * POST /api/products
     * Tworzy nowy produkt.
     * - 201 CREATED – gdy produkt został dodany
     * - 400 BAD REQUEST – gdy dane są niepoprawne
     * - 409 CONFLICT – gdy produkt o danym ID już istnieje
     */
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {

        if (product.getId() <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Product id must be positive"));
        }

        if (PRODUCTS.containsKey(product.getId())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Product with this id already exists"));
        }

        PRODUCTS.put(product.getId(), product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
