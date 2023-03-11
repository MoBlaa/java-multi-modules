package org.myshelf.java19modules.domain;

import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;

@AllArgsConstructor
public class UserRegisterInteractor implements UserInputBoundary {
    private final UserRegisterDsGateway userDsGateway;
    private final UserPresenter userPresenter;
    private final UserFactory userFactory;
    private final Clock clock;


    @Override
    public UserResponseDto create(UserRequestDto requestModel) {
        if (userDsGateway.existsByName(requestModel.name())) {
            return userPresenter.prepareFailView("User with name %s already exists".formatted(requestModel.name()));
        }
        User user = userFactory.create(requestModel.name(), requestModel.password());
        String checkResult = user.passwordIsValid();
        if (checkResult != null) {
            return userPresenter.prepareFailView("Password invalid: %s".formatted(checkResult));
        }
        LocalDateTime now = LocalDateTime.now(clock);
        UserDsRequestDto userDsModel = new UserDsRequestDto(user.getName(), user.getPassword(), now);

        UserDsResponseDto createdUser = userDsGateway.save(userDsModel);

        UserResponseDto accountResponseModel = new UserResponseDto(createdUser.id(), user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}
