package org.myshelf.java19modules.domain;

import java.time.LocalDateTime;

public record UserDsRequestDto(
        String name,
        String password,
        LocalDateTime updatedAt
) {
}
