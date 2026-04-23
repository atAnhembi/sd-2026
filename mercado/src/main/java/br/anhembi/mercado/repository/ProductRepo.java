package br.anhembi.mercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.anhembi.mercado.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    // JPA Query Methods
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.price = :price")
    List<Product> findPriceIquals(double price);
}