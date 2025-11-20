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

    private static final Map<Integer, Product> PRODUCTS = new LinkedHashMap<>();

    static {
        PRODUCTS.put(1, new Product(1, "Szalunek ścienny 1m2", "Szalunek do ścian, stalowy", 20.0));
        PRODUCTS.put(2, new Product(2, "Rusztowanie modułowe", "Rusztowanie - 2m wysokości", 45.0));
        PRODUCTS.put(3, new Product(3, "Zestaw podpór", "Podpory regulowane", 10.0));
    }

    // GET /api/products
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(new ArrayList<>(PRODUCTS.values()));
    }

    // GET /api/products/{id} with manual validation so /api/products/abc -> 400
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String idStr) {
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // 400 Bad Request per Lab 2 (zła składnia parametru)
            Map<String, String> body = Map.of("error", "Bad request: id must be an integer");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        Product p = PRODUCTS.get(id);
        if (p == null) {
            Map<String, String> body = Map.of("error", "Product not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        return ResponseEntity.ok(p);
    }
}
