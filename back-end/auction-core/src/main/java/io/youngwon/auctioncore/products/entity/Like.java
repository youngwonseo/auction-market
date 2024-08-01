package io.youngwon.auctioncore.products.entity;

import io.youngwon.auctioncore.products.entity.id.LikeId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@IdClass(LikeId.class)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "likes")
public class Like {

    @Id
    private Long productId;

    @Id
    private Long createdBy;

    @CreatedDate
    private LocalDateTime createdAt;


    @Builder
    public static Like of(long productId, long createdBy) {
        Like like = new Like();
        like.productId = productId;
        like.createdBy = createdBy;
        return like;
    }
}
