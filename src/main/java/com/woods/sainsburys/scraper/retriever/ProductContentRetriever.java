package com.woods.sainsburys.scraper.retriever;

import com.woods.sainsburys.scraper.ProductTransformer;
import com.woods.sainsburys.scraper.page.PageFactory;
import com.woods.sainsburys.scraper.page.PageSizeCalculator;
import com.woods.sainsburys.scraper.page.PageType;
import com.woods.sainsburys.scraper.page.product.ProductPage;
import com.woods.sainsburys.scraper.page.product.ProductPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPage;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageProduct;
import com.woods.sainsburys.scraper.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductContentRetriever {

    private final PageFactory pageFactory;
    private final PageSizeCalculator pageSizeCalculator;
    private final ProductTransformer productTransformer;

    public static final String PRODUCT_LIST_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    @Autowired
    public ProductContentRetriever(PageFactory pageFactory, PageSizeCalculator pageSizeCalculator, ProductTransformer productTransformer)
    {
        this.pageFactory = pageFactory;
        this.pageSizeCalculator = pageSizeCalculator;
        this.productTransformer = productTransformer;
    }

    public List<Product> retrieve() throws Exception {

        ProductListPageContent productListContent = getProductListPageContent();

        List<Product> products = new ArrayList<Product>();

        for (ProductListPageProduct listPageProduct : productListContent.getProducts())
        {
            Product product = productTransformer.transform(listPageProduct, getProductPageContent(listPageProduct.getProductUrl()), pageSizeCalculator.getSize(listPageProduct.getProductUrl()));
            products.add(product);
        }

        return products;
    }

    private ProductListPageContent getProductListPageContent() throws Exception {
        ProductListPage productListPage = (ProductListPage) pageFactory.getPage(PageType.PRODUCT_LIST, PRODUCT_LIST_URL);
        return (ProductListPageContent) productListPage.getContent();
    }

    private ProductPageContent getProductPageContent(String url) throws Exception {

        ProductPage productPage = (ProductPage) pageFactory.getPage(PageType.PRODUCT, url);
        return (ProductPageContent) productPage.getContent();
    }
}