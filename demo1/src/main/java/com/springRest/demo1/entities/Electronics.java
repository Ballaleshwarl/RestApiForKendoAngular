package com.springRest.demo1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Electronics {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long productId;

    private String  productName;

    private String  productPrice;

    private String productStocks;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStocks() {
        return productStocks;
    }

    public void setProductStocks(String productStocks) {
        this.productStocks = productStocks;
    }

    public Electronics(Long productId, String productName, String productPrice, String productStocks) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStocks = productStocks;
    }

    public Electronics() {
    }
}
