package br.anhembi.mercado.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.anhembi.mercado.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornecedor", nullable = false)
    @JsonIgnoreProperties("products")
    private Fornecedor fornecedor;

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

    public Product(Long id, String name, double price, Fornecedor fornecedor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fornecedor = fornecedor;
    }

    public ProductDTO toDTO() {
        return new ProductDTO(this);
    }

    public Long getId() {
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
