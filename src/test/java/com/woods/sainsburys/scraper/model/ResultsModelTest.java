package com.woods.sainsburys.scraper.model;



import junit.framework.TestCase;
import org.junit.Assert;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;

public class ResultsModelTest extends TestCase {

    public void testTotalResultsPrice()
    {
        ResultsModel resultsModel = new ResultsModel();
        ProductModel productModel = new ProductModel();
        productModel.setPrice(new BigDecimal(1.1));
        resultsModel.addResult(productModel);
        Assert.assertThat(resultsModel.getTotal(), is("1.10"));
    }

    public void testTotalResultsPriceWithTwoProducts()
    {
        ResultsModel resultsModel = new ResultsModel();
        ProductModel productModel = new ProductModel();
        productModel.setPrice(new BigDecimal(1.1));
        resultsModel.addResult(productModel);
        ProductModel productModel2 = new ProductModel();
        productModel2.setPrice(new BigDecimal(2.3));
        resultsModel.addResult(productModel2);
        Assert.assertThat(resultsModel.getTotal(), is("3.40"));
    }
}