package com.woods.sainsburys.scraper.page.productlist;

import java.math.BigDecimal;

public class ProductListPageProduct {

    private String title;
    private BigDecimal price;
    private String productUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
