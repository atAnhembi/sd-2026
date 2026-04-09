package br.anhembi.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.mercado.model.Product;
import br.anhembi.mercado.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Optional<Product> getProduct(long id) {
        return repo.getProduct(id);

    }

    public List<Product> getAll() {
        return repo.getAll();
    }

}
