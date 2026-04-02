package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Product;
import com.klu.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // Save product
    public Product saveProduct(Product p) {
        return productRepo.save(p);
    }

    // a. findByCategory
    public List<Product> getByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    // b. findByPriceBetween
    public List<Product> getByPriceRange(double min, double max) {
        return productRepo.findByPriceBetween(min, max);
    }

    // JPQL: sorted by price
    public List<Product> getSortedProducts() {
        return productRepo.getAllProductsSortedByPrice();
    }

    // JPQL: expensive products
    public List<Product> getExpensiveProducts(double price) {
        return productRepo.findProductsAbovePrice(price);
    }
}