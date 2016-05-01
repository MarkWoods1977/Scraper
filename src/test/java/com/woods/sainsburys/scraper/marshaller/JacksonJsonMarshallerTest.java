package com.woods.sainsburys.scraper.marshaller;

import com.woods.sainsburys.scraper.calculation.Kilobyte;
import com.woods.sainsburys.scraper.model.ProductModel;
import com.woods.sainsburys.scraper.model.ResultsModel;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JacksonJsonMarshallerTest extends TestCase {

    public void testMarshallFormat() throws Exception {

        ResultsModel resultsModel = new ResultsModel();
        resultsModel.addResult(createProductModel("Sainsbury's Apricot Ripe & Ready x5", new BigDecimal(1.80), new Kilobyte(new BigDecimal(1234)), "Apricot"));
        resultsModel.addResult(createProductModel("Sainsbury's Avacado, Ripe & Ready x5", new BigDecimal(2.00), new Kilobyte(new BigDecimal(87)), "Avacado"));

        JacksonJsonMarshaller jacksonJsonMarshaller = new JacksonJsonMarshaller();
        String resultModelString = jacksonJsonMarshaller.objectToString(resultsModel);

        String expected = "{\"results\":[{\"title\":\"Sainsbury's Apricot Ripe & Ready x5\",\"size\":\"1.2Kb\",\"unit_price\":\"1.80\",\"description\":\"Apricot\"},{\"title\":\"Sainsbury's Avacado, Ripe & Ready x5\",\"size\":\"0.1Kb\",\"unit_price\":\"2.00\",\"description\":\"Avacado\"}],\"total\":\"3.80\"}";
        assertThat(resultModelString, is(expected));
    }

    private ProductModel createProductModel(String title, BigDecimal price, Kilobyte size, String description) {

        ProductModel productModel = new ProductModel();
        productModel.setTitle(title);
        productModel.setPrice(price);
        productModel.setSize(size);
        productModel.setDescription(description);

        return productModel;
    }

}