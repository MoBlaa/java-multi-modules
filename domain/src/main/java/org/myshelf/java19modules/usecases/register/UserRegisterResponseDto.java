package org.myshelf.java19modules.usecases.register;

public record UserRegisterResponseDto(
        Long id,
        String name,
        String createdAt
) {
}
