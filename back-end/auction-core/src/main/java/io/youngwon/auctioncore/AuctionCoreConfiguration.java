package io.youngwon.auctioncore;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan
@EnableScheduling
@EnableJpaAuditing
@EnableAutoConfiguration
public class AuctionCoreConfiguration {
}
