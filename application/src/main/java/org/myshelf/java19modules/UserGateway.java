package org.myshelf.java19modules;

import lombok.AllArgsConstructor;
import org.myshelf.java19modules.domain.UserDsRequestDto;
import org.myshelf.java19modules.domain.UserDsResponseDto;
import org.myshelf.java19modules.domain.UserRegisterDsGateway;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserGateway implements UserRegisterDsGateway {
    final UserRepository repository;

    @Override
    public boolean existsByName(String name) {
        return repository.existsById(name);
    }

    @Override
    public UserDsResponseDto save(UserDsRequestDto requestModel) {
        var userEntity = new UserEntity();
        userEntity.setName(requestModel.name());
        userEntity.setPassword(requestModel.password());
        userEntity.setUpdatedAt(requestModel.updatedAt());
        userEntity = repository.save(userEntity);
        return new UserDsResponseDto(userEntity.getId(), userEntity.getName(), userEntity.getUpdatedAt());
    }
}
