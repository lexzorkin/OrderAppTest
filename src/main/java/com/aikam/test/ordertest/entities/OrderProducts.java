package com.aikam.test.ordertest.entities;

import javax.persistence.*;

@Entity
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantityProducts;


    public OrderProducts() {

    }

    public OrderProducts(Product product, Integer quantityProducts) {
        this.product = product;
        this.quantityProducts = quantityProducts;
    }

    public Double getTotalPrice() {
        return product.getPrice() * quantityProducts;
    }

    public String getProductName() {
        return product.getName();
    }

    public Double getProductPrice() {
        return product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(Integer quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

    @Override
    public String toString() {
        return "OrderProducts{" +
                "id=" + id +
                ", product=" + product +
                ", quantityProducts=" + quantityProducts +
                '}';
    }
}
