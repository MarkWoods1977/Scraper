package com.woods.sainsburys.scraper.page.productlist;

import com.woods.sainsburys.scraper.page.Page;
import com.woods.sainsburys.scraper.page.PageContent;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;

public class ProductListPage implements Page {

    private Elements productElements;
    private final Document document;

    public ProductListPage(Document document) {
        this.document = document;
    }

    public PageContent getContent() {

        ProductListPageContent productListPageContent = new ProductListPageContent();

        Elements productElements = getProductList();

        for (Element productElement : productElements) {

            ProductListPageProduct product = new ProductListPageProduct();
            product.setTitle(getProductTitle(productElement));
            product.setPrice(new BigDecimal(getProductPrice(productElement)));
            product.setProductUrl(getProductPageLinkUrl(productElement));

            productListPageContent.addProduct(product);
        }

        return productListPageContent;
    }

    private Elements getProductList() {

        if(productElements != null)
            return productElements;

        productElements = document.select(".product");

        return productElements;
    }

    private String getProductTitle(Element productElement) {

        Elements productInfo = productElement.select(".productInfo h3 a");
        Element element = productInfo.first();
        return element.ownText();
    }

    private String getProductPrice(Element productElement) {

        Elements priceNode = productElement.select(".pricePerUnit");
        String[] price = priceNode.text().split("/|&pound");
        return price[1];
    }

    private String getProductPageLinkUrl(Element productElement) {
        Elements productInfo = productElement.select(".productInfo h3 a");
        return productInfo.attr("href");
    }
}