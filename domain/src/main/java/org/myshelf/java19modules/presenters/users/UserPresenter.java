package org.myshelf.java19modules.presenters.users;

import org.myshelf.java19modules.usecases.register.UserRegisterResponseDto;

public interface UserPresenter {
    UserRegisterResponseDto prepareSuccessView(UserRegisterResponseDto user);

    UserRegisterResponseDto prepareFailView(String error);
}
