package org.myshelf.java19modules.gateways.users;

import java.time.LocalDateTime;

public record UserDsRequestDto(
        String name,
        String password,
        LocalDateTime updatedAt
) {
}
