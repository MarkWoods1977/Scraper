package com.woods.sainsburys.scraper.page.productlist;

import com.woods.sainsburys.scraper.page.PageContent;

import java.util.ArrayList;
import java.util.List;

public class ProductListPageContent implements PageContent {

    private final List<ProductListPageProduct> products = new ArrayList<ProductListPageProduct>();

    public void addProduct(ProductListPageProduct product) {

        products.add(product);
    }

    public List<ProductListPageProduct> getProducts() {
        return products;
    }
}