package com.cognizant.orm_learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import java.util.List;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Language;
import com.cognizant.orm_learn.model.State;
import com.cognizant.orm_learn.repository.CountryRepository;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        countryRepository = context.getBean(CountryRepository.class);

    	testCustomQueries();

        testCountryOperations();
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		getCountryTest();
		testAddCountry(); 
        testGetAllCountries(); 
        getCountryTest(); 
		testQueryMethods();

    }
	@Autowired
private static CountryRepository countryRepository;

private static void testCountryRelationships() {
    LOGGER.info("Start");

    Country country = countryRepository.findById("IN").get();

    List<State> states = country.getStates();
    LOGGER.debug("States of IN: {}", states);

    List<Language> langs = country.getLanguages();
    LOGGER.debug("Languages spoken in IN: {}", langs);

    LOGGER.info("End");
}
private static void testCustomQueries() {
    LOGGER.info("Start - Custom Queries");

    List<Country> countries = countryRepository.findCountriesStartingWith("A");
    LOGGER.debug("Countries starting with A: {}", countries);

    Country countryWithLangs = countryRepository.fetchCountryWithLanguages("IN");
    LOGGER.debug("Country with languages: {}", countryWithLangs);

    long count = countryRepository.countCountries();
    LOGGER.debug("Total countries: {}", count);

    List<Country> nativeSearch = countryRepository.searchCountriesByNameNative("India");
    LOGGER.debug("Native Query Result: {}", nativeSearch);

    LOGGER.info("End - Custom Queries");
}


	private static void testQueryMethods() {
    LOGGER.info("Start");

    LOGGER.info("Countries containing 'land':");
    List<Country> containing = countryService.findByNameContaining("land");
    containing.forEach(c -> LOGGER.debug("{}", c));

    LOGGER.info("Countries starting with 'A':");
    List<Country> startingWithA = countryService.findByNameStartingWith("A");
    startingWithA.forEach(c -> LOGGER.debug("{}", c));

    LOGGER.info("Countries sorted by name:");
    List<Country> sorted = countryService.getAllCountriesSorted();
    sorted.forEach(c -> LOGGER.debug("{}", c));

    LOGGER.info("Top 3 countries by name:");
    List<Country> top3 = countryService.getTop3Countries();
    top3.forEach(c -> LOGGER.debug("{}", c));

    LOGGER.info("End");
}


    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("All countries: {}", countries);
        LOGGER.info("End");
    }

    private static void testCountryOperations() {
        LOGGER.info("Start");

        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Zzland");
        countryService.addCountry(newCountry);

List<Country> countries = countryService.getAllCountries();
LOGGER.debug("All countries: {}", countries);

try {
    Country country = countryService.findCountryByCode("IN");
    LOGGER.debug("Found country: {}", country);

    country.setName("Updated India");
    countryService.updateCountry(country);

    List<Country> matches = countryService.findCountriesByPartialName("land");
    LOGGER.debug("Matching countries: {}", matches);

    countryService.deleteCountry("ZZ");

} catch (CountryNotFoundException e) {
    LOGGER.error("Exception: {}", e.getMessage());
}

        LOGGER.info("End");
    }
	private static void getCountryTest() {
    LOGGER.info("Start");
    try {
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
    } catch (CountryNotFoundException e) {
        LOGGER.error("Exception: {}", e.getMessage());
    }
    LOGGER.info("End");
}
private static void testAddCountry() {
    LOGGER.info("Start");

    Country newCountry = new Country();
    newCountry.setCode("XY");
    newCountry.setName("Xyzland");

    countryService.addCountry(newCountry);

    try {
        Country retrievedCountry = countryService.findCountryByCode("XY");
        LOGGER.debug("Added Country: {}", retrievedCountry);
    } catch (CountryNotFoundException e) {
        LOGGER.error("Country not found after add: {}", e.getMessage());
    }

    LOGGER.info("End");
}


}
