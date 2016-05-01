package com.woods.sainsburys.scraper.page;

import com.woods.sainsburys.scraper.calculation.Kilobyte;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CountingInputStream;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class PageSizeCalculator {

    public Kilobyte getSize(String productURL) throws Exception{

        CountingInputStream counter = null;
        try {
            final URL url = new URL(productURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            counter = new CountingInputStream(con.getInputStream());
            IOUtils.toString(counter);
            return new Kilobyte(new BigDecimal(counter.getByteCount()));
        } finally {
            IOUtils.closeQuietly(counter);
        }
    }
}