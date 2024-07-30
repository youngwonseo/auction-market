package io.youngwon.app.api.dto;

import io.youngwon.app.domain.auctions.entity.Auctions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AuctionsResponseDto {

    private Long id;
    private Long price;
    private Long productsId;
    private LocalDateTime createdAt;

    public AuctionsResponseDto(Auctions auctions) {
        this.id = auctions.getId();
        this.price = auctions.getPrice();
        this.productsId = auctions.getProducts().getId();
        this.createdAt = auctions.getCreatedAt();
    }
}
