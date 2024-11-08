package UMC.spring;

import UMC.spring.service.storeService.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            StoreQueryService storeService = context.getBean(StoreQueryService.class);

            String storeName = "요아정";
            BigDecimal storeRate = BigDecimal.valueOf(4.0);

            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("Name: " + storeName);
            System.out.println("Score: " + storeRate);

            storeService.findStoresByNameAndScore(storeName, storeRate)
                    .forEach(System.out::println);
        };


    }
}

