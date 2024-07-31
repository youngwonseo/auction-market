package io.youngwon.app.domain.products.entity;

import io.youngwon.app.domain.products.entity.id.LikeId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
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
}
