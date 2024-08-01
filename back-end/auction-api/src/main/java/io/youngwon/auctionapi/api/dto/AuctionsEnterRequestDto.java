package io.youngwon.auctionapi.api.dto;

import io.youngwon.auctioncore.auctions.entity.Auctions;
import io.youngwon.auctioncore.products.entity.Product;
import io.youngwon.auctioncore.users.entity.User;
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
