package org.myshelf.java19modules;

import org.myshelf.java19modules.domain.UserPresenter;
import org.myshelf.java19modules.domain.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class UserRegisterResponseFormatter implements UserPresenter {
    @Override
    public UserResponseDto prepareSuccessView(UserResponseDto user) {
        LocalDateTime responseTime = LocalDateTime.parse(user.createdAt());
        return new UserResponseDto(
                user.id(),
                user.name(),
                responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"))
        );
    }

    @Override
    public UserResponseDto prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
