package com.woods.sainsburys.scraper.model;

import com.woods.sainsburys.scraper.calculation.Kilobyte;
import com.woods.sainsburys.scraper.product.Product;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultsModelBuilderTest extends TestCase {

    final String TITLE = "Sainsbury's Apricot Ripe & Ready x5";

    public void testBuildsWithProduct()
    {
        Kilobyte pageSize = mock(Kilobyte.class);
        when(pageSize.toString()).thenReturn("25Kb");

        Product product = new Product();
        product.setTitle(TITLE);
        product.setPageSize(pageSize);
        product.setProductPrice(new BigDecimal(1.20));

        List<Product> products = asList(product);

        ResultsModelBuilder resultsModelBuilder = new ResultsModelBuilder(products);

        ResultsModel resultsModel = resultsModelBuilder.build();

        assertThat(resultsModel.getResults().get(0).getTitle(), is(TITLE));
    }



}