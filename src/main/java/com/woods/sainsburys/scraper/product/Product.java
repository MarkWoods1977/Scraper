package com.woods.sainsburys.scraper.product;

import com.woods.sainsburys.scraper.calculation.Kilobyte;

import java.math.BigDecimal;

public class Product {

    private String title;
    private BigDecimal price;
    private String productUrl;
    private Kilobyte pageSize;
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setProductPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPageSize(Kilobyte pageSize) {
        this.pageSize = pageSize;
    }

    public Kilobyte getPageSize() {
        return pageSize;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
