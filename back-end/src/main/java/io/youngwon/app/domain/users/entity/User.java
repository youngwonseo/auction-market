package io.youngwon.app.domain.users.entity;

import io.youngwon.app.security.Jwt;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(Long id) {
        this.id = id;
    }

    @Builder
    public User(String name, String email, Role role, String vender, String socialId) {
        this.name = name;
        this.email = email;
        this.role = role;

        if ("kakao".equals(vender)) {
            this.kakaoId = socialId;
        } else if ("naver".equals(vender)) {
            this.naverId = socialId;
        }

    }

    public User update(String name) {
        this.name = name;
        return this;
    }


    public String newJwt(Jwt jwt, String[] roles) {
        Jwt.Claims claims = Jwt.Claims.of(id, name, roles);
        return jwt.create(claims);
    }

}
