package com.woods.sainsburys.scraper.model;

import com.woods.sainsburys.scraper.calculation.Kilobyte;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@JsonPropertyOrder({ "title", "size", "unit_price", "description"})
public class ProductModel {

    private String title = "";
    private Kilobyte size;
    protected BigDecimal price;
    private String description = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size.toString();
    }

    public void setSize(Kilobyte size) {
        this.size = size;
    }

    public String getUnit_price() {

        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
