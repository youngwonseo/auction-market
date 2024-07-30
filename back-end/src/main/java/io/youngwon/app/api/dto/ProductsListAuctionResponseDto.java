package io.youngwon.app.api.dto;

import io.youngwon.app.domain.products.entity.Categories;
import io.youngwon.app.domain.products.entity.Product;
import io.youngwon.app.domain.categories.dto.CategoriesTitleResponseDto;
import io.youngwon.app.domain.products.entity.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
public class ProductsListAuctionResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long startPrice;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<FilesListResponseDto> images;
    private Integer numOfLike;
    private Integer viewCount;
    private Long price;
    private State state;

    private List<CategoriesTitleResponseDto> categories = new ArrayList<CategoriesTitleResponseDto>();

    public ProductsListAuctionResponseDto(Product entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.startPrice = entity.getStartPrice();
        this.startDateTime = entity.getStartDateTime();
        this.endDateTime = entity.getEndDateTime();

        this.viewCount = entity.getViewCount();

        this.state = entity.getState();
        // 가장 하위
        Categories temp = entity.getCategories();
        while (temp != null) {
            this.categories.add(0, new CategoriesTitleResponseDto(temp));
            temp = temp.getParent();
        }

        if (entity.getAuctions().size() > 0) {
            this.price = entity.getAuctions().get(0).getPrice();
        }


        this.images = entity.getFiles()
                .stream()
                .map(FilesListResponseDto::new)
                .collect(Collectors.toList());

        this.numOfLike = entity.getLikes().size();
    }

}
