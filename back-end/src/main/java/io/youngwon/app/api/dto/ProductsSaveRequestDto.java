package io.youngwon.app.api.dto;

import io.youngwon.app.domain.products.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
public class ProductsSaveRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Images[] images;

    @NotNull
    private Long startPrice;

    @NotBlank
    private LocalDateTime startDateTime;

    @NotBlank
    private LocalDateTime endDateTime;

    @NotNull
    private Long categories;

    private String[] tags;


    public Product toEntity(Long userId) {
        return new Product(this, userId);
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class Images {
        private String dataURL;
    }
}
