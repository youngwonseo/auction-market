package io.youngwon.auctionapi.api.dto;

import java.math.BigDecimal;


public record AuctionsBidRequest(
        BigDecimal price
) {
}
