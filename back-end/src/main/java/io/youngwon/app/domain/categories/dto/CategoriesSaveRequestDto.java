package io.youngwon.app.domain.categories.dto;

import io.youngwon.app.domain.products.entity.Categories;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoriesSaveRequestDto {

    @NotBlank
    private String title;

    private Long parent;

    @Builder
    public CategoriesSaveRequestDto(String title, Long parent) {
        this.title = title;
        this.parent = parent;
    }

    public Categories toEntity() {
        return Categories.builder()
                .title(title)
                .parent(parent != null ? new Categories(parent) : null)
                .build();
    }

}
