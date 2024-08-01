package io.youngwon.auctionapi.api.dto;

public record FileResponse(
        Long id,
        String path,
        String filename
) {
}
