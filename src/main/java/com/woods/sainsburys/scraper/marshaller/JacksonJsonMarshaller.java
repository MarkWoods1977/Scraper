package com.woods.sainsburys.scraper.marshaller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("jsonMarshaller")
public class JacksonJsonMarshaller implements JsonMarshaller {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String objectToString(Object object) throws IOException {

        return objectMapper.writeValueAsString(object);
    }
}
