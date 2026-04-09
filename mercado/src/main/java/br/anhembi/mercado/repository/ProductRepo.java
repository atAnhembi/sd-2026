package br.anhembi.mercado.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.mercado.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
