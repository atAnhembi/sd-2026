package br.anhembi.mercado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.anhembi.mercado.model.Product;

@Repository
public class ProductRepo {

    private List<Product> products = List.of(
            new Product(1, "Teclado Gamer", 250),
            new Product(2, "PC Gamer", 2500),
            new Product(3, "Cadeira Gamer", 950));

    public Optional<Product> getProduct(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return Optional.of(p);
            }
        }
        return Optional.empty();

    }

    public List<Product> getAll() {
        return products;
    }
}
