package io.youngwon.auctioncore.users.entity;

import io.youngwon.auctioncore.users.model.LoginProvider;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String kakaoId;
    private String naverId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public User update(LoginProvider provider, String providerId, String name) {
        switch (provider) {
            case KAKAO -> this.kakaoId = providerId;
            case NAVER -> this.naverId = providerId;
        }
        this.name = name;
        return this;
    }

    public static User of(Long id) {
        User user = new User();
        user.id = id;
        return user;
    }



    @Builder
    public User(LoginProvider provider, String providerId, String name, String email) {
        this.name = name;
        this.email = email;
        switch (provider) {
            case KAKAO -> this.kakaoId = providerId;
            case NAVER -> this.naverId = providerId;
        }
    }
}
