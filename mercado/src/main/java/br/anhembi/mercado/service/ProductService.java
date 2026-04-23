package br.anhembi.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.mercado.dto.ProductDTO;
import br.anhembi.mercado.exceptions.ProductNotFoundException;
import br.anhembi.mercado.model.Product;
import br.anhembi.mercado.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Optional<Product> getProduct(long id) {
        return repo.findById(id);
    }

    public List<Product> getAll() {
        return (List<Product>) repo.findAll();
    }

    public boolean deleteById(long id) {
        if(!repo.existsById(id)) {
            throw new ProductNotFoundException("Product id Not found");
        }
        repo.deleteById(id);
        return true;
    }

    public Optional<Product> insert(ProductDTO dto) {
        Optional<Product> result = Optional.empty();
        Product product = dto.toProduct();
        // if (isValid(product)) {
        result = Optional.of(repo.save(product));
        // }
        return result;
    }

    public boolean updateAll(Product product) {
        boolean result = false;
        if (isValid(product) && repo.existsById(product.getId())) {
            repo.save(product);
            result = true;
        }
        return result;
    }

    public boolean update(Product product) {
        boolean result = false;
        if (repo.existsById(product.getId())) {
            Product productDB = repo.findById(product.getId()).get();
            if (product.getName() != null && product.getName().length() > 0) {
                productDB.setName(product.getName());
            }
            if (product.getPrice() > 0) {
                productDB.setPrice(product.getPrice());
            }
            repo.save(productDB);
            result = true;
        }
        return result;
    }

    private boolean isValid(Product product) {
        boolean result = (product.getPrice() > 0 &&
                product.getName() != null &&
                product.getName().trim().length() >= 1);
        return result;
    }

    public List<Product> findByPriceGreaterThan(double price) {
        return repo.findByPriceGreaterThan(price);
    }

    public List<Product> findByPrice(double price) {
        return repo.findPriceIquals(price);
    }
}
