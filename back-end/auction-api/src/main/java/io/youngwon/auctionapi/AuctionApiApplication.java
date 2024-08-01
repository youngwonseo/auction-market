package io.youngwon.auctionapi;

import io.youngwon.auctioncore.AuctionCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AuctionCoreConfiguration.class)
@SpringBootApplication
public class AuctionApiApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-api");
        SpringApplication.run(AuctionApiApplication.class, args);
    }
}
