package pl.ordersys;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.ordersys.core.restaurant.RestaurantService;

import java.util.Arrays;

/**
 * <h1>Food Ordering System<h1/>
 * The Fod Ordering System implements an application that
 * provide restaurant ordering system with special requirements,
 * describe in readme.md file.
 *
 * @author Dawid Janik
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "pl.ordersys")
@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationStarter {

    private static String path = ".//src//main//resources//food.xlsx";

    /**
     * This is the main method that launches thread of Application,
     * and also is trying to take object from Excel file (which keep all restaurant data).
     * After successful operation this method launch General View of command-line interface.
     *
     * @param args unused or used depends of method giving a initial path of Excel file.
     */
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RestaurantService.class, args);
        RestaurantService restaurantService = ctx.getBean(RestaurantService.class);

        restaurantService.startRestaurantSystem();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
