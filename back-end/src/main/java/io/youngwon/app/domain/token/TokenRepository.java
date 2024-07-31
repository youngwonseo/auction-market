package io.youngwon.app.domain.token;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TokenRepository {
    private final RedisTemplate<String, String> redisTemplate;



}
