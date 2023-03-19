package org.myshelf.java19modules.gateways;

import lombok.AllArgsConstructor;
import org.myshelf.java19modules.gateways.users.UserDsGateway;
import org.myshelf.java19modules.gateways.users.UserDsRequestDto;
import org.myshelf.java19modules.gateways.users.UserDsResponseDto;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDao implements UserDsGateway {
  final UserRepository repository;

  @Override
  public boolean existsByName(String name) {
    return repository.existsByName(name);
  }

  @Override
  public UserDsResponseDto save(UserDsRequestDto requestModel) {
    var userEntity = new UserEntity();
    userEntity.setName(requestModel.name());
    userEntity.setPassword(requestModel.password());
    userEntity.setUpdatedAt(requestModel.updatedAt());
    userEntity = repository.save(userEntity);
    return new UserDsResponseDto(
        userEntity.getId(), userEntity.getName(), userEntity.getUpdatedAt());
  }
}
