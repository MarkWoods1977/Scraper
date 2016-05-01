package com.woods.sainsburys.scraper.page;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import static org.jsoup.Jsoup.connect;

@Component
class PageRetriever {

    public Document getDocument(String url) throws Exception {

        return connect(url)
                .maxBodySize(0)
                .timeout(5000)
                .get();
    }
}