package br.anhembi.mercado.dto;

import java.util.List;

import br.anhembi.mercado.model.Fornecedor;
import br.anhembi.mercado.model.Product;

public class FornecedorDTO {
    private String nome;
    private List<Product> products;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Fornecedor toFornecedor() {
        return new Fornecedor(nome, products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
