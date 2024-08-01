package io.youngwon.auctioncore.auctions.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AuctionPriceRepository {
    private final RedisTemplate<String, String> redisTemplate;

    private static final String PRODUCT_KEY = "product:%d";
    private final RedisScript<Boolean> bidScript = RedisScript.of("""
                if redis.call('EXISTS', KEYS[1]) == 1 then
                    local current_price = tonumber(redis.call('HGET', KEYS[1], 'price'))
                    if current_price and current_price < tonumber(ARGV[1]) then
                        redis.call('HSET', KEYS[1], 'price', ARGV[1], 'userId', ARGV[2])
                        return 'true'
                    end
                else
                    redis.call('HSET', KEYS[1], 'price', ARGV[1], 'userId', ARGV[2])
                    return 'true'
                end
                return 'false'
            """, Boolean.class);

    public boolean bid(Long productId, BigDecimal price, Long userId) {
        return redisTemplate.execute(bidScript,
                List.of(PRODUCT_KEY.formatted(productId)),
                String.valueOf(price),
                String.valueOf(userId));
    }

}
