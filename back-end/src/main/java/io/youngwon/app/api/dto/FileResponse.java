package io.youngwon.app.api.dto;

public record FileResponse(
        Long id,
        String path,
        String filename
) {
}
