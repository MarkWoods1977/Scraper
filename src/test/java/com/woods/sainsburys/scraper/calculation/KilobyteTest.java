package com.woods.sainsburys.scraper.calculation;

import junit.framework.TestCase;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class KilobyteTest extends TestCase {

    public void testRandomNumber()
    {
        BigDecimal input = new BigDecimal(25866);
        String expectedOutput = "25.3Kb";
        Kilobyte kilobyte = new Kilobyte(input);

        String actualOutput = kilobyte.toString();

        assertThat(actualOutput, is(expectedOutput));
    }

    public void testZeroNumber()
    {
        Kilobyte kilobyte = new Kilobyte(new BigDecimal(0));
        String expectedOutput = "0Kb";

        String actualOutput = kilobyte.toString();

        assertThat(actualOutput, is(expectedOutput));
    }







}