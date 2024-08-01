package io.youngwon.auctioncore.auctions;

import io.youngwon.auctioncore.EmbeddedRedis;
import io.youngwon.auctioncore.auctions.service.AuctionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Import(EmbeddedRedis.class)
@ActiveProfiles("test")
public class AuctionServiceTests {


    @Autowired
    private AuctionService auctionService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @BeforeEach
    public void beforeEach() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.serverCommands().flushAll();
    }


    @Test
    @DisplayName("경매 시작")
    void startBid() {

    }

    @Test
    @DisplayName("경매 참여")
    void bid() {

    }

}
