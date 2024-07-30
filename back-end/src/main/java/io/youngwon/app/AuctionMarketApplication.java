package io.youngwon.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class AuctionMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuctionMarketApplication.class, args);
    }
}
