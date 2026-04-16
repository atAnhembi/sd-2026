package br.anhembi.mercado.dto;

import br.anhembi.mercado.model.Product;

public class ProductDTO {
    private String name;
    private double price;

    public ProductDTO(){}
    
    public ProductDTO(Product product){
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Product toProduct() {
        return new Product(null, name, price);
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
