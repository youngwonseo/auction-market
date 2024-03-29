package io.youngwon.app.domain.auctions.dto;

import io.youngwon.app.domain.auctions.domain.Auctions;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AuctionsResponseDto {

    private Long id;
    private Long price;
    private Long productsId;
    private LocalDateTime createdAt;

    public AuctionsResponseDto(Auctions auctions){
        this.id = auctions.getId();
        this.price = auctions.getPrice();
        this.productsId = auctions.getProducts().getId();
        this.createdAt = auctions.getCreatedAt();
    }
}
