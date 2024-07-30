package io.youngwon.app.domain.products.entity;


import io.youngwon.app.api.dto.ProductsSaveRequestDto;
import io.youngwon.app.domain.auctions.entity.Auctions;
import io.youngwon.app.domain.comments.domain.Comments;
import io.youngwon.app.domain.files.Files;
import io.youngwon.app.domain.users.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    private String title;

    private String content;

    @ColumnDefault("0")
    private Integer viewCount;

    private Long startPrice;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private State state;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Files> files = new ArrayList<>();

    @OrderBy("createdAt desc")
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Auctions> auctions = new ArrayList<>();

    @OrderBy("createdAt desc")
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Tagging> taggings = new ArrayList<>();

    public Product(Long id) {
        this.id = id;
    }


    public Product(ProductsSaveRequestDto requestDto, Long seller) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.startPrice = requestDto.getStartPrice();
        this.categories = new Categories(requestDto.getCategories());
        this.seller = new User(seller);

        // 초기등록시 무조건 대기
        this.state = State.WAITING;
        this.viewCount = 0;
        this.startDateTime = requestDto.getStartDateTime();
        this.endDateTime = requestDto.getEndDateTime();

        if (requestDto.getImages() != null) {
            this.files.addAll(Arrays.stream(requestDto.getImages())
                    .map(n -> new Files(this, n))
                    .collect(Collectors.toList()));
        }
    }

    public void update(String title, String content, Long startPrice) {
        this.title = title;
        this.content = content;
        this.startPrice = startPrice;
    }

    public Auctions addAuctions(Auctions auction) {
        this.auctions.add(auction);
        return auction;
    }

    public void addComments(Comments comments) {
        this.comments.add(comments);
    }

    public void updateComents(Long id, String content) {
//        this.comments.
    }

    public void deleteComents(Long id) {

    }

    public void onSale() {
        this.state = State.SELLING;
    }

    public void finish() {
        this.state = State.FINISH;
    }

    public Integer like(Like likes) {
        this.likes.add(likes);
        return this.likes.size();
    }

    public Integer unlike(Like likes) {
        this.likes.remove(likes);
        return this.likes.size();
    }

    public void increaseViewCount() {
        this.viewCount += 1;
    }

}

