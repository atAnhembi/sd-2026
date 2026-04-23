package br.anhembi.mercado.dto;

import br.anhembi.mercado.model.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank
    private String name;
    @Min(1)
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Product toProduct() {
        Product result = new Product(null, name, price);
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
