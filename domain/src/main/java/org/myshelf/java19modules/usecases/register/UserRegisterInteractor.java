package org.myshelf.java19modules.usecases.register;

import java.time.Clock;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.myshelf.java19modules.domain.User;
import org.myshelf.java19modules.domain.UserFactory;
import org.myshelf.java19modules.gateways.users.UserDsGateway;
import org.myshelf.java19modules.gateways.users.UserDsRequestDto;
import org.myshelf.java19modules.gateways.users.UserDsResponseDto;
import org.myshelf.java19modules.presenters.users.UserPresenter;

@AllArgsConstructor
public class UserRegisterInteractor implements UserRegisterInputBoundary {
  private final UserDsGateway userDsGateway;
  private final UserPresenter userPresenter;
  private final UserFactory userFactory;
  private final Clock clock;

  @Override
  public UserRegisterResponseDto register(UserRegisterRequestDto requestModel) {
    if (userDsGateway.existsByName(requestModel.name())) {
      return userPresenter.prepareFailView(
          "User with name %s already exists".formatted(requestModel.name()));
    }
    User user = userFactory.create(requestModel.name(), requestModel.password());
    String checkResult = user.passwordIsValid();
    if (checkResult != null) {
      return userPresenter.prepareFailView("Password invalid: %s".formatted(checkResult));
    }
    LocalDateTime now = LocalDateTime.now(clock);
    UserDsRequestDto userDsModel = new UserDsRequestDto(user.getName(), user.getPassword(), now);

    UserDsResponseDto createdUser = userDsGateway.save(userDsModel);

    UserRegisterResponseDto accountResponseModel =
        new UserRegisterResponseDto(createdUser.id(), user.getName(), now.toString());
    return userPresenter.prepareSuccessView(accountResponseModel);
  }
}
