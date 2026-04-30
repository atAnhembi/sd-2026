package br.anhembi.mercado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.mercado.dto.ProductDTO;
import br.anhembi.mercado.model.Product;
import br.anhembi.mercado.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Optional<Product> opProduct = service.getProduct(id);
        if (opProduct.isPresent()) {
            return ResponseEntity.ok(opProduct.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody @Valid ProductDTO dto) {
        ResponseEntity<Product> result = ResponseEntity.badRequest().build();
        Optional<Product> product = service.insert(dto);
        if (product.isPresent()) {
            result = ResponseEntity.status(HttpStatus.CREATED).body(product.get());
        }
        return (result);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateAll(@RequestBody Product product) {
        ResponseEntity<Boolean> result = ResponseEntity.badRequest().build();
        if (service.updateAll(product)) {
            result = ResponseEntity.ok().build();
        }
        return (result);
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody Product product) {
        ResponseEntity<Boolean> result = ResponseEntity.badRequest().build();
        if (service.update(product)) {
            result = ResponseEntity.ok().build();
        }
        return (result);
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Product>> findPriceGreater(@PathVariable double price) {
        return ResponseEntity.ok(service.findByPriceGreaterThan(price));
    }

    @GetMapping("/priceequals/{price}")
    public ResponseEntity<List<Product>> findPriceEquals(@PathVariable double price) {
        return ResponseEntity.ok(service.findByPrice(price));
    }
}
