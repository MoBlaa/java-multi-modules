package org.myshelf.java19modules.domain;

public interface UserRegisterDsGateway {
    boolean existsByName(String name);

    UserDsResponseDto save(UserDsRequestDto requestModel);
}
