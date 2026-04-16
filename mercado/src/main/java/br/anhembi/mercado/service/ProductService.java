package br.anhembi.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.mercado.dto.ProductDTO;
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
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    public Optional<Product> insert(ProductDTO productDTO) {
        if (isValid(productDTO.toProduct())) {
            return Optional.empty();
        }
        return Optional.of(repo.save(productDTO.toProduct()));
    }

    public boolean updateAll(Product product) {
        if (isValid(product)) {
            if (repo.existsById(product.getId())) {
                repo.save(product);
                return true;
            }
        }
        return false;
    }

    public boolean update(Product product) {
        if (repo.existsById(product.getId())) {
            Product productBD = repo.findById(product.getId()).get();
            if (product.getName() != null && product.getName().length() > 0) {
                productBD.setName(product.getName());
            }
            if (product.getPrice() > 0) {
                productBD.setPrice(product.getPrice());
            }
            repo.save(productBD);
            return true;
        }
        return false;
    }

    private boolean isValid(Product product) {
        return product.getPrice() > 0 &&
                product.getName() != null &&
                product.getName().trim().length() > 0;
    }
}
