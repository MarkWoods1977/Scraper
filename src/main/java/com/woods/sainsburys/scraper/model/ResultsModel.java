package com.woods.sainsburys.scraper.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ResultsModel {

    private final List<ProductModel> results = new ArrayList<ProductModel>();

    public List<ProductModel> getResults() {
        return results;
    }

    public void addResult(ProductModel result) {
        this.results.add(result);
    }

    public String getTotal()
    {
        BigDecimal total = new BigDecimal(0.0);

        for (ProductModel productModel : results){
            total = total.add(productModel.price);
        }

        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(total);
    }
}