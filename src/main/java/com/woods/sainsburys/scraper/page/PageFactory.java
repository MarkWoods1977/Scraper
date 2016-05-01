package com.woods.sainsburys.scraper.page;

import com.woods.sainsburys.scraper.page.product.ProductPage;
import com.woods.sainsburys.scraper.page.productlist.ProductListPage;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageFactory {

    private final PageRetriever pageRetriever;

    @Autowired
    public PageFactory(PageRetriever pageRetriever)
    {
        this.pageRetriever = pageRetriever;
    }

    public Page getPage(PageType pageType, String url) throws Exception {

        Document document = pageRetriever.getDocument(url);

        switch (pageType) {
            case PRODUCT_LIST:
                return new ProductListPage(document);
            case PRODUCT:
                return new ProductPage(document);
            default: throw new RuntimeException();
        }
    }
}
