package io.youngwon.app.domain.products.entity;

import io.youngwon.app.domain.users.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "likes")
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "products")
    private Product products;

    @ManyToOne
    @JoinColumn(name = "users")
    private User users;

    @CreatedDate
    private LocalDateTime createdAt;

    public Like(Product products, User users) {
        this.products = products;
        this.users = users;
    }
}
