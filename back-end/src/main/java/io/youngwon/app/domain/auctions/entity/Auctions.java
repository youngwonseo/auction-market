package io.youngwon.app.domain.auctions.entity;


import io.youngwon.app.domain.products.entity.Product;
import io.youngwon.app.domain.users.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Auctions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product products;

    @ManyToOne
    private User participants;

    private Boolean isCancel;

    private Long price;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Auctions(Product products, Long price, User participants) {
        this.products = products;
        this.price = price;
        this.participants = participants;
        this.isCancel = false;

    }

    public void cancel() {
        this.isCancel = true;
    }
}
