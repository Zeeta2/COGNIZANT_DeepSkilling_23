package com.cognizant.spring_learn;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountries();
        LOGGER.info("END");
    }
    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            List<Country> countryList = context.getBean("countryList", List.class);
            LOGGER.debug("Country List : {}", countryList);
        }
        LOGGER.info("END");
    }
}