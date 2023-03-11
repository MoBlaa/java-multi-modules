package org.myshelf.java19modules.domain;

public interface UserPresenter {
    UserResponseDto prepareSuccessView(UserResponseDto user);

    UserResponseDto prepareFailView(String error);
}
