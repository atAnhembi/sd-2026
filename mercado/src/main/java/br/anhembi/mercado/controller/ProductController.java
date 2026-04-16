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
        if(service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO) {
        Optional<Product> productOptional = service.insert(productDTO);
        if(productOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Boolean> updateAll(@RequestBody Product product) {
         boolean updated = service.updateAll(product);
         if(updated) {
            return ResponseEntity.ok().build();
         }
         return ResponseEntity.badRequest().build();
    }

    @PatchMapping
    public ResponseEntity<Boolean> update(@RequestBody Product product) {
         boolean updated = service.update(product);
         if(updated) {
            return ResponseEntity.ok().build();
         }
         return ResponseEntity.badRequest().build();
    }
 
}
