package com.woods.sainsburys.scraper.page.product;

import com.woods.sainsburys.scraper.page.Page;
import com.woods.sainsburys.scraper.page.PageContent;
import com.woods.sainsburys.scraper.product.Product;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductPage implements Page {

    private final Document document;
    private Product product;

    public ProductPage(Document document) {
        this.document = document;
    }

    public PageContent getContent() {

        ProductPageContent productPageContent = new ProductPageContent();
        productPageContent.setDescription(getDescription());

        return productPageContent;
    }

    private String getDescription() {

        Elements productText = document.select(".productText");
        Element element = productText.first();
        return element.text();
    }
}
