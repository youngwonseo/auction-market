package io.youngwon.auctionapi.api.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AuctionResponse(
        Long id,
        BigDecimal price,
        LocalDateTime createdAt,
        Boolean isCancel
) {
}
