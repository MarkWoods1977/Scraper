package com.woods.sainsburys.scraper.page;

import com.woods.sainsburys.scraper.page.product.ProductPage;
import com.woods.sainsburys.scraper.page.productlist.ProductListPage;
import junit.framework.TestCase;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URL;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PageFactoryTest  {

    public static final String URL = "Url";
    PageFactory pageFactory;

    @Mock PageRetriever pageRetriever;
    @Mock Document document;

    @Before
    public void setUp() throws Exception {

        pageFactory = new PageFactory(pageRetriever);
        when(pageRetriever.getDocument(URL)).thenReturn(document);
    }

    @Test
    public void testGetProductListPage() throws Exception {

        Page page = pageFactory.getPage(PageType.PRODUCT_LIST, URL);

        verify(pageRetriever).getDocument(URL);
        assertThat(page, is(instanceOf(ProductListPage.class)));
    }

    @Test
    public void testGetProductPage() throws Exception {

        Page page = pageFactory.getPage(PageType.PRODUCT, URL);

        verify(pageRetriever).getDocument(URL);
        assertThat(page, is(instanceOf(ProductPage.class)));

    }
}