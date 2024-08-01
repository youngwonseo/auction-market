package io.youngwon.auctionapi.api.dto;

public record UserResponse(
        Long id,
        String email,
        String name
) {
}
