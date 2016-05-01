package com.woods.sainsburys.scraper.acceptance;

import com.woods.sainsburys.scraper.Scraper;
import com.woods.sainsburys.scraper.calculation.Kilobyte;
import com.woods.sainsburys.scraper.model.ProductModel;
import com.woods.sainsburys.scraper.model.ResultsModel;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ScraperAcceptanceTest {

    @Autowired
    private Scraper scraper;

    @Test
    public void testScrape() throws Exception {

        String jsonString = scraper.scrape();

        String expectedJsonString = "{\"results\":[{\"title\":\"Sainsbury's Apricot Ripe & Ready x5\",\"size\":\"38.3Kb\",\"unit_price\":\"3.50\",\"description\":\"Apricots\"},{\"title\":\"Sainsbury's Avocado Ripe & Ready XL Loose 300g\",\"size\":\"38.7Kb\",\"unit_price\":\"1.50\",\"description\":\"Avocados\"},{\"title\":\"Sainsbury's Avocado, Ripe & Ready x2\",\"size\":\"43.4Kb\",\"unit_price\":\"1.80\",\"description\":\"Avocados\"},{\"title\":\"Sainsbury's Avocados, Ripe & Ready x4\",\"size\":\"38.7Kb\",\"unit_price\":\"3.20\",\"description\":\"Avocados\"},{\"title\":\"Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)\",\"size\":\"38.5Kb\",\"unit_price\":\"1.50\",\"description\":\"Conference\"},{\"title\":\"Sainsbury's Golden Kiwi x4\",\"size\":\"38.6Kb\",\"unit_price\":\"1.80\",\"description\":\"Gold Kiwi\"},{\"title\":\"Sainsbury's Kiwi Fruit, Ripe & Ready x4\",\"size\":\"39Kb\",\"unit_price\":\"1.80\",\"description\":\"Kiwi\"}],\"total\":\"15.10\"}";

        assertThat(jsonString, is(expectedJsonString));
    }
}