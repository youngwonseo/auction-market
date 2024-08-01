package io.youngwon.auctionapi.api.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {

    private String vendor;
    private String code;
}
