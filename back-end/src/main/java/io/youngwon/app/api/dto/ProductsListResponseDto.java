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
public class ProductsListResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long startPrice;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<FilesListResponseDto> images;

    private Integer numOfLike;
    private Boolean isLike;
    private Integer viewCount;
    private Long price;
    private State state;


    private List<CategoriesTitleResponseDto> categories = new ArrayList<>();

    private UserResponseDto seller;

    private LocalDateTime createdAt;
    // 경매 진행중 여부

    // 경매 진행중일시 경과 시간

    // 현재 가격


    public ProductsListResponseDto(Product entity, Long userId) {
        this.id = entity.getId();
        this.title = entity.getTitle();

        this.content = entity.getContent();
        if (content.length() > 80) {
            content = content.substring(0, 70) + "...";
        }

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

        this.seller = new UserResponseDto(entity.getSeller());

        this.images = entity.getFiles()
                .stream()
                .map(FilesListResponseDto::new)
                .collect(Collectors.toList());

        this.numOfLike = entity.getLikes().size();

        // 내가 지금 라이크를 하고 있는가?
        this.isLike = entity.getLikes()
                .stream()
                .filter(like -> like.getUsers().getId() == userId)
                .collect(Collectors.toList()).size() > 0;

        this.createdAt = entity.getCreatedAt();

    }


}
