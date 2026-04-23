package br.anhembi.mercado.model;

import br.anhembi.mercado.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this(null, name, price);
    }

    public Product(Long id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }
    
    public ProductDTO toDTO () {
        return new ProductDTO(this);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
