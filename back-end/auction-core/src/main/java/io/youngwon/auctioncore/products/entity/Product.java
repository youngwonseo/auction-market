package io.youngwon.auctioncore.products.entity;


import io.youngwon.auctioncore.auctions.entity.Auctions;
import io.youngwon.auctioncore.exception.NotImplementedException;
import io.youngwon.auctioncore.users.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Where(clause = "deleted_at IS NULL")
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private ProductState state;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private BigDecimal startPrice;
    private Long likeCount;
    private Long viewCount;
    private Long categoryId;


    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

//    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Files> files = new ArrayList<>();
//
//    @OrderBy("createdAt desc")
//    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Auctions> auctions = new ArrayList<>();

    @Builder
    public Product(String title, String content, BigDecimal startPrice, Long categoryId, LocalDateTime startDateTime, LocalDateTime endDateTime, User createdBy) {
        this.title = title;
        this.content = content;
        this.state = ProductState.WAIT;
        this.startPrice = startPrice;
        this.categoryId = categoryId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.createdBy = createdBy;
    }

    public void update(String title,
                       String content,
                       BigDecimal startPrice,
                       LocalDateTime startDateTime,
                       LocalDateTime endDateTime) {
        this.title = title;
        this.content = content;
        this.startPrice = startPrice;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Auctions addAuctions(Auctions auction) {
//        this.auctions.add(auction);
        return auction;
    }

    public void onSale() {
        this.state = ProductState.SELLING;
    }

    public void finish() {
        this.state = ProductState.FINISHED;
    }

    public Integer like(Like likes) {
//        this.likes.add(likes);
//        return this.likes.size();
        throw new NotImplementedException();
    }

    public Integer unlike(Like likes) {
        throw new NotImplementedException();
//        this.likes.remove(likes);
//        return this.likes.size();
    }

    public void increaseViewCount() {
        this.viewCount += 1;
    }

    public boolean delete() {
        if (deletedAt != null) {
            return false;
        }
        this.deletedAt = LocalDateTime.now();
        return true;
    }

}

