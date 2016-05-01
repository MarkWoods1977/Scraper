package com.woods.sainsburys.scraper.retriever;

import com.woods.sainsburys.scraper.ProductTransformer;
import com.woods.sainsburys.scraper.calculation.Kilobyte;
import com.woods.sainsburys.scraper.page.PageFactory;
import com.woods.sainsburys.scraper.page.PageSizeCalculator;
import com.woods.sainsburys.scraper.page.PageType;
import com.woods.sainsburys.scraper.page.product.ProductPage;
import com.woods.sainsburys.scraper.page.product.ProductPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPage;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageProduct;
import com.woods.sainsburys.scraper.product.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductContentRetrieverTest {

    public static final String PRODUCT_URL = "PRODUCT_URL";

    @Mock ProductListPage productListPage;
    @Mock ProductListPageContent productListPageContent;
    @Mock ProductPage productPage;
    @Mock ProductPageContent productPageContent;
    @Mock Kilobyte kilobyte;
    @Mock private PageFactory pageFactory;
    @Mock private PageSizeCalculator pageSizeCalculator;
    @Mock private ProductTransformer productTransformer;

   private ProductContentRetriever productContentRetriever;

    @Before
    public void setUp() throws Exception {

        productContentRetriever = new ProductContentRetriever(pageFactory, pageSizeCalculator, productTransformer);
    }

    @Test
    public void retrievesProduct() throws Exception {

        when(pageFactory.getPage(PageType.PRODUCT_LIST, ProductContentRetriever.PRODUCT_LIST_URL)).thenReturn(productListPage);
        when(productListPage.getContent()).thenReturn(productListPageContent);

        ProductListPageProduct productListPageProduct = new ProductListPageProduct();
        productListPageProduct.setProductUrl(PRODUCT_URL);
        when(productListPageContent.getProducts()).thenReturn(asList(productListPageProduct));

        when(pageFactory.getPage(PageType.PRODUCT, PRODUCT_URL)).thenReturn(productPage);
        when(productPage.getContent()).thenReturn(productPageContent);

        when(pageSizeCalculator.getSize(PRODUCT_URL)).thenReturn(kilobyte);

        Product product = new Product();
        when(productTransformer.transform(productListPageProduct, productPageContent, kilobyte)).thenReturn(product);

        List<Product> products = productContentRetriever.retrieve();

        assertThat(products.get(0), is(product));
    }
}
