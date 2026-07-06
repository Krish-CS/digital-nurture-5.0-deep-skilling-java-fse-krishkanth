package com.cognizant.ormlearn;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testSearchCountryByName();
    }
    
    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }
    
    private static void testFindCountryByCode() throws Exception {
        LOGGER.info("Start testFindCountryByCode");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End testFindCountryByCode");
    }
    
    private static void testAddCountry() throws Exception {
        LOGGER.info("Start testAddCountry");
        Country country = new Country("ZZ", "Test Country");
        countryService.addCountry(country);
        Country added = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added Country: {}", added);
        LOGGER.info("End testAddCountry");
    }
    
    private static void testUpdateCountry() throws Exception {
        LOGGER.info("Start testUpdateCountry");
        countryService.updateCountry("ZZ", "Updated Test Country");
        Country updated = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated Country: {}", updated);
        LOGGER.info("End testUpdateCountry");
    }
    
    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (Exception e) {
            LOGGER.debug("ZZ successfully deleted");
        }
        LOGGER.info("End testDeleteCountry");
    }
    
    private static void testSearchCountryByName() {
        LOGGER.info("Start testSearchCountryByName");
        List<Country> countries = countryService.searchCountryByName("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End testSearchCountryByName");
    }
}