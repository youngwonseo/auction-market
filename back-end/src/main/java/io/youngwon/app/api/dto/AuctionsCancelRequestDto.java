package io.youngwon.app.api.dto;

import lombok.Getter;

@Getter
public class AuctionsCancelRequestDto {
    private Long productsId;
    private Long auctionsId;
}
