package org.myshelf.java19modules.domain;

import java.time.LocalDateTime;

public record UserDsResponseDto(
        Long id,
        String name,
        LocalDateTime updatedAt
) {
}
