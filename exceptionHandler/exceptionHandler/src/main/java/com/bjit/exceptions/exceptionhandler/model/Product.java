package com.bjit.exceptions.exceptionhandler.model;

public class Product {
    private Integer id;
    private String productName;

    public Product() {
    }

    public Product(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
