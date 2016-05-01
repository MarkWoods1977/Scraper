package com.woods.sainsburys.scraper.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Kilobyte {

    private final BigDecimal bytes;

    public Kilobyte(BigDecimal bytes) {

        this.bytes = bytes;
    }

    public String toString()
    {
        BigDecimal kilobytes = bytes.divide(new BigDecimal(1024));
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(kilobytes) + "Kb";
    }
}
