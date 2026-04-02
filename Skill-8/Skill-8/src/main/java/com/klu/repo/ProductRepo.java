package com.klu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.klu.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	public List<Product> findByCategory(String Category);
	List<Product> findByPriceBetween(double min, double max);

    // JPQL Queries

    // a. Sorting products by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getAllProductsSortedByPrice();

    // b. Fetch products above a price
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findProductsAbovePrice(double price);

    // c. Fetch by category
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategory(String category);
	

}
