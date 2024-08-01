package io.youngwon.auctionapi.api.dto;

import lombok.Getter;

@Getter
public class AuctionsCancelRequestDto {
    private Long productsId;
    private Long auctionsId;
}
