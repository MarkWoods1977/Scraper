package com.woods.sainsburys.scraper.model;

import com.woods.sainsburys.scraper.product.Product;

import java.util.List;

public class ResultsModelBuilder {

    private final List<Product> products;
    private final ResultsModel resultsModel = new ResultsModel();

    public ResultsModelBuilder(List<Product> products)
    {
        this.products = products;
    }

    public ResultsModel build()
    {
        for (Product product : products)
        {
            addProductToResults(product);
        }

        return resultsModel;
    }

    private void addProductToResults(Product product) {

        ProductModel productModel = new ProductModel();
        productModel.setTitle(product.getTitle());
        productModel.setSize(product.getPageSize());
        productModel.setPrice(product.getPrice());
        productModel.setDescription(product.getDescription());

        resultsModel.addResult(productModel);
    }
}