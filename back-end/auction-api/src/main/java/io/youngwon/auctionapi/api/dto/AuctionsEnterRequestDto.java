package io.youngwon.auctionapi.api.dto;

import io.youngwon.auctioncore.domain.auctions.entity.Auctions;
import io.youngwon.auctioncore.domain.products.entity.Product;
import io.youngwon.auctioncore.domain.users.entity.User;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public class AuctionsEnterRequestDto {


    private BigDecimal price;

    public Auctions toEntity(Product products, User users) {
        return Auctions.builder().products(products).price(price).createdBy(users)
                .build();
    }
}
