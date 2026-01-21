package com.ztpai.controller;

import com.ztpai.dto.ProductDto;
import com.ztpai.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
@Tag(
        name = "Products",
        description = "Operacje na produktach dostepnych do wynajmu"
)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Pobierz liste produktow",
            description = "Zwraca wszystkie produkty dostepne w systemie"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista produktow",
            content = @Content(schema = @Schema(implementation = ProductDto.class))
    )
    @ApiResponse(
            responseCode = "204",
            description = "Brak produktow w systemie"
    )
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

    @Operation(
            summary = "Pobierz produkt po ID",
            description = "Zwraca pojedynczy produkt na podstawie identyfikatora"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Produkt znaleziony",
            content = @Content(schema = @Schema(implementation = ProductDto.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Bledny format ID"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Produkt nie istnieje"
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        int productId;

        try {
            productId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Bad request: id must be an integer"));
        }

        return productService.getProductById(productId)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("error", "Product not found"))
                );
    }
}
