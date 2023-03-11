package org.myshelf.java19modules.domain;

public record UserResponseDto(
        Long id,
        String login,
        String createdAt
) {
}
