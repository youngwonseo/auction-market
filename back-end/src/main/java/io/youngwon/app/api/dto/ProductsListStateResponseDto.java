package io.youngwon.app.api.dto;

import io.youngwon.app.domain.products.entity.Product;
import io.youngwon.app.domain.products.entity.State;
import lombok.Getter;

@Getter
public class ProductsListStateResponseDto {
    private Long id;
    private State state;

    public ProductsListStateResponseDto(Product products) {
        this.id = products.getId();
        this.state = products.getState();
    }

}
