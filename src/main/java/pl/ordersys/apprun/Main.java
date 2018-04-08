package pl.ordersys.apprun;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.ordersys.core.RedData;
import pl.ordersys.view.GeneralView;
import pl.ordersys.view.MainView;

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
@AllArgsConstructor
public class Main {

    private static String path = ".//src//main//resources//food.xlsx";

    /**
     * This is the main method that launches thread of Application,
     * and also is trying to take object from Excel file (which keep all restaurant data).
     * After successful operation this method launch General View of command-line interface.
     *
     * @param args unused or used depends of method giving a initial path of Excel file.
     */
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        GeneralView generalView = context.getBean(GeneralView.class);

        generalView.view();

//        log.info("Let's inspect the beans provided by Spring:");
//        String[] beanNames = context.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            log.info(beanName);
//        }

//        if (args.length != 0) {
//            path = args[0];
//            log.debug("Deployed path /" + path);
//        }
//        ThreadApp threadApp = new ThreadApp();
//        threadApp.start();
//        RedData.getContent(path);

    }
}
