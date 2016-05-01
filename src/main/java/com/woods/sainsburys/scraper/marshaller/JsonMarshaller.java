package com.woods.sainsburys.scraper.marshaller;

import java.io.IOException;

public interface JsonMarshaller <T> {

    String objectToString(T object) throws IOException;

}
