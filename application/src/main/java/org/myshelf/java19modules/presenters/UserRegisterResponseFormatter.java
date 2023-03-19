package org.myshelf.java19modules.presenters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.myshelf.java19modules.presenters.users.UserPresenter;
import org.myshelf.java19modules.usecases.register.UserRegisterResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserRegisterResponseFormatter implements UserPresenter {
  @Override
  public UserRegisterResponseDto prepareSuccessView(UserRegisterResponseDto user) {
    LocalDateTime responseTime = LocalDateTime.parse(user.createdAt());
    return new UserRegisterResponseDto(
        user.id(), user.name(), responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
  }

  @Override
  public UserRegisterResponseDto prepareFailView(String error) {
    throw new ResponseStatusException(HttpStatus.CONFLICT, error);
  }
}
