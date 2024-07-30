package io.youngwon.app.api.dto;

import io.youngwon.app.domain.users.entity.User;
import io.youngwon.app.exception.NotImplementedException;

public class LoginResponseDto {


    private final String token;

    private final UserResponseDto user;

    public LoginResponseDto(String token, User user) {
        this.token = token;
        this.user = new UserResponseDto(user);
    }

    public String getToken() {
        return token;
    }

    public UserResponseDto getUser() {
        return user;
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
//        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
//                .append("token", token)
//                .append("user", user)
//                .toString();
    }

}
