package io.youngwon.app.domain.products.entity;

import io.youngwon.app.domain.products.entity.id.TaggingId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@IdClass(TaggingId.class)
@NoArgsConstructor
@Entity
public class Tagging {

    @Id
    private Long tagId;

    @Id
    private Long productId;
}
