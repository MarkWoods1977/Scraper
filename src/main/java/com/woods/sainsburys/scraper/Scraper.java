package com.woods.sainsburys.scraper;

import com.woods.sainsburys.scraper.marshaller.JsonMarshaller;
import com.woods.sainsburys.scraper.model.ResultsModel;
import com.woods.sainsburys.scraper.model.ResultsModelBuilder;
import com.woods.sainsburys.scraper.product.Product;
import com.woods.sainsburys.scraper.retriever.ProductContentRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scraper {


    private final JsonMarshaller jsonMarshaller;
    private final ProductContentRetriever productContentRetriever;

    @Autowired
    public Scraper(JsonMarshaller jsonMarshaller, ProductContentRetriever productContentRetriever)
    {
        this.jsonMarshaller = jsonMarshaller;
        this.productContentRetriever = productContentRetriever;
    }

    public String scrape() throws Exception {

        List<Product> products = productContentRetriever.retrieve();
        ResultsModel resultsModel = new ResultsModelBuilder(products).build();
        return jsonMarshaller.objectToString(resultsModel);
    }
}