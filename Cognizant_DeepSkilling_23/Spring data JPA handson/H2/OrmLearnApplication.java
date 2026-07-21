package com.cognizant.ormlearn;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static StockRepository stockRepository;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class,
                        args);

        stockRepository =
                context.getBean(StockRepository.class);

        testFacebookStocks();
        testGoogleStocks();
        testTopVolumeStocks();
        testNetflixStocks();
    }

    private static void testFacebookStocks() {

        System.out.println("\nFACEBOOK STOCKS - SEPTEMBER 2019\n");

        stockRepository
                .findByCodeAndDateBetween(
                        "FB",
                        LocalDate.of(2019, 9, 1),
                        LocalDate.of(2019, 9, 30))
                .forEach(System.out::println);
    }

    private static void testGoogleStocks() {

        System.out.println("\nGOOGLE STOCKS > 1250\n");

        stockRepository
                .findByCodeAndCloseGreaterThan(
                        "GOOGL",
                        1250)
                .forEach(System.out::println);
    }

    private static void testTopVolumeStocks() {

        System.out.println("\nTOP 3 VOLUME STOCKS\n");

        stockRepository
                .findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);
    }

    private static void testNetflixStocks() {

        System.out.println("\nLOWEST NETFLIX STOCKS\n");

        stockRepository
                .findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}