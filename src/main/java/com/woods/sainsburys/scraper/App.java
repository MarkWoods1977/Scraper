package com.woods.sainsburys.scraper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scraper scraper = context.getBean(Scraper.class);

        try {
            System.out.println(scraper.scrape());
        } catch (Exception e) {
            System.out.println("There was an issue scraping page");
        }
    }
}
