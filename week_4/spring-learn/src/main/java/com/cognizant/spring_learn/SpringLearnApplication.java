package com.cognizant.spring_learn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	 
    public static void displayDate() throws Exception {
    LOGGER.info("START");

    ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
    SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

    Date date = format.parse("31/12/2018");
    LOGGER.debug("Parsed Date: {}", date);

    LOGGER.info("END");
}
public static void displayCountry() {
    LOGGER.info("START");

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    Country country = context.getBean("country", Country.class);
    Country anotherCountry = context.getBean("country", Country.class);

    LOGGER.debug("Country      : {}", country);
    LOGGER.debug("AnotherCountry : {}", anotherCountry);

    LOGGER.info("END");
}
public static void displayCountries() {
    LOGGER.info("START");

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    List<Country> countryList = context.getBean("countryList", List.class);

    LOGGER.debug("Country List: {}", countryList);

    LOGGER.info("END");
}


    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        try {
            displayDate();
			displayCountry(); 
			displayCountries();
        } catch (Exception e) {
            LOGGER.error("Exception occurred while displaying date", e);
        }
        LOGGER.info("END");
}
}