package org.myshelf.java19modules.gateways.users;

import java.time.LocalDateTime;

public record UserDsResponseDto(Long id, String name, LocalDateTime updatedAt) {}
