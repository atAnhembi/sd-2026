package br.anhembi.mercado.dto;

import br.anhembi.mercado.model.Fornecedor;
import br.anhembi.mercado.model.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank
    private String name;
    @Min(1)
    private double price;
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Product toProduct() {
        Product result = new Product(null, name, price, fornecedor);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
