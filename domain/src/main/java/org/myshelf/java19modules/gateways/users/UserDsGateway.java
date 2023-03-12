package org.myshelf.java19modules.gateways.users;

public interface UserDsGateway {
    boolean existsByName(String name);

    UserDsResponseDto save(UserDsRequestDto requestModel);
}
