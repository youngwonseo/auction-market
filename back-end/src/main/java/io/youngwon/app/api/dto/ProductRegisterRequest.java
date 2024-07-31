package io.youngwon.app.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record ProductRegisterRequest(
        @NotBlank String title,
        @NotBlank String content,
        Images[] images,
        @NotNull BigDecimal startPrice,
        @NotBlank LocalDateTime startDateTime,
        @NotBlank LocalDateTime endDateTime,
        @NotNull Long categories,
        String[] tags
) {

    @ToString
    @Getter
    @NoArgsConstructor
    public static class Images {
        private String dataURL;
    }
}
