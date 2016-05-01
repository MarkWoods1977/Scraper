package com.woods.sainsburys.scraper.page.product;

import com.woods.sainsburys.scraper.page.PageContent;

public class ProductPageContent implements PageContent {

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
