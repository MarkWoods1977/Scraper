package com.woods.sainsburys.scraper;

import com.woods.sainsburys.scraper.calculation.Kilobyte;
import com.woods.sainsburys.scraper.marshaller.JsonMarshaller;
import com.woods.sainsburys.scraper.model.ProductModel;
import com.woods.sainsburys.scraper.model.ResultsModel;
import com.woods.sainsburys.scraper.page.PageFactory;
import com.woods.sainsburys.scraper.page.PageSizeCalculator;
import com.woods.sainsburys.scraper.page.PageType;
import com.woods.sainsburys.scraper.page.product.ProductPage;
import com.woods.sainsburys.scraper.page.product.ProductPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPage;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageContent;
import com.woods.sainsburys.scraper.page.productlist.ProductListPageProduct;
import com.woods.sainsburys.scraper.product.Product;
import com.woods.sainsburys.scraper.retriever.ProductContentRetriever;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScraperTest {

    public static final String PRICE = "1.80";
    public static final String TITLE = "Sainsbury's Apricot Ripe & Ready x5";
    public static final int SIZE = 1234;
    public static final String DESCRIPTION = "Apricot";

    @Mock ProductContentRetriever productContentRetriever;
    @Mock JsonMarshaller jsonMarshaller;
    @Mock Product product;

    Scraper scraper;

    @Before
    public void setUp() throws Exception {

        scraper = new Scraper(jsonMarshaller, productContentRetriever);
    }

    @Test
    public void scrapesPages() throws Exception {

        List<Product> products = asList(buildProduct(TITLE, new BigDecimal(PRICE), new Kilobyte(new BigDecimal(SIZE)), DESCRIPTION));

        when(productContentRetriever.retrieve()).thenReturn(products);

        scraper.scrape();

        ArgumentCaptor<ResultsModel> argument = ArgumentCaptor.forClass(ResultsModel.class);

        verify(jsonMarshaller).objectToString(argument.capture());

        ProductModel productModel = argument.getValue().getResults().get(0);

        assertThat(productModel.getTitle(), is(product.getTitle()));
        assertThat(productModel.getUnit_price(), is(PRICE));
        assertThat(productModel.getDescription(), is(product.getDescription()));
        assertThat(productModel.getSize(), is(product.getPageSize().toString()));
    }

    private Product buildProduct(String title, BigDecimal price, Kilobyte pageSize, String description)
    {
        product = new Product();
        product.setTitle(title);
        product.setProductPrice(price);
        product.setDescription(description);
        product.setPageSize(pageSize);

        return product;
    }
}




















