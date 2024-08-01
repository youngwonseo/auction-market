package io.youngwon.auctionapi.api.dto;

import io.youngwon.auctioncore.products.entity.ProductState;
import io.youngwon.auctioncore.products.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ProductListResponse(
        Long id,
        String title,
        String content,
        BigDecimal startPrice,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        List<FileResponse> images,
        ProductState productState,
        List<AuctionResponse> auctions,
        Long viewCount,
        Long likeCount,
        Boolean isLike,
        Long participantCount,
        List<CategoryResponse> categories
) {
    public static ProductListResponse of(Product entity, Boolean isLike) {
        return new ProductListResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getStartPrice(),
                entity.getStartDateTime(),
                entity.getEndDateTime(),
                List.of(),
                entity.getState(),
                List.of(),
                entity.getViewCount(),
                entity.getLikeCount(), // 컬럼으로
                isLike,
                0L,
                List.of());
    }
}