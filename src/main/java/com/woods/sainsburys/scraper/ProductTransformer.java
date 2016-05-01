package com.woods.sainsburys.scraper;

import com.woods.sainsburys.scraper.calculation.Kilobyte;
import com.woods.sainsburys.scraper.page.product.ProductPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageProduct;
import com.woods.sainsburys.scraper.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer {

    public Product transform(ProductListPageProduct productListPageProduct, ProductPageContent productPageContent, Kilobyte productPageSize) {

        Product product = new Product();
        product.setTitle(productListPageProduct.getTitle());
        product.setProductPrice(productListPageProduct.getPrice());
        product.setProductUrl(productListPageProduct.getProductUrl());
        product.setDescription(productPageContent.getDescription());
        product.setPageSize(productPageSize);

        return product;
    }
}