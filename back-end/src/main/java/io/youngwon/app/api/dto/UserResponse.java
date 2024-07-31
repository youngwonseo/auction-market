package io.youngwon.app.api.dto;

public record UserResponse(
        Long id,
        String email,
        String name
) {
}
