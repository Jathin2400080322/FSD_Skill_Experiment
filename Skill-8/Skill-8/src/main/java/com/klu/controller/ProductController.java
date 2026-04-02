package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Save
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
        return ResponseEntity.ok(productService.saveProduct(p));
    }

    // a. /products/category/{category}
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.getByCategory(category));
    }

    // b. /products/filter?min=&max=
    @GetMapping("/filter")
    public ResponseEntity<List<Product>> getByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {
        return ResponseEntity.ok(productService.getByPriceRange(min, max));
    }

    // c. /products/sorted
    @GetMapping("/sorted")
    public ResponseEntity<List<Product>> getSortedProducts() {
        return ResponseEntity.ok(productService.getSortedProducts());
    }

    // d. /products/expensive/{price}
    @GetMapping("/expensive/{price}")
    public ResponseEntity<List<Product>> getExpensiveProducts(@PathVariable double price) {
        return ResponseEntity.ok(productService.getExpensiveProducts(price));
    }
}