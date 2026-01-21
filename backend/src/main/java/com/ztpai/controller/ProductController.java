package com.ztpai.controller;

import com.ztpai.dto.ProductDto;
import com.ztpai.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET /api/products
     * - 200 OK – gdy produkty istnieją
     * - 204 NO CONTENT – gdy brak danych
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/{id}
     * - 200 OK – znaleziono
     * - 404 NOT FOUND – brak produktu
     * - 400 BAD REQUEST – błędny format ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        try {
            int productId = Integer.parseInt(id);
            return productService.getProductById(productId)
                    .map(ResponseEntity::ok)
                    .orElseGet(() ->
                            ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body(Map.of("error", "Product not found"))
                    );
        } catch (NumberFormatException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Bad request: id must be an integer"));
        }
    }
}
