package io.youngwon.auctionapi.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record ProductUpdateRequest(
        String title,
        String content,
        BigDecimal startPrice,
        LocalDateTime startDate,
        LocalDateTime endDateTime
) {
}
