package io.youngwon.app.api.dto;

import io.youngwon.app.domain.users.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSaveRequestDto {
    private String name;
    private String email;

    public User toEntity() {
        return User.builder().name(this.name).email(this.email).build();
    }
}
