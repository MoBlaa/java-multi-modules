package org.myshelf.java19modules.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.myshelf.java19modules.gateways.users.UserDsRequestDto;
import org.myshelf.java19modules.gateways.users.UserDsResponseDto;
import org.myshelf.java19modules.gateways.users.UserDsGateway;
import org.myshelf.java19modules.presenters.users.UserPresenter;
import org.myshelf.java19modules.usecases.register.UserRegisterInteractor;
import org.myshelf.java19modules.usecases.register.UserRegisterRequestDto;
import org.myshelf.java19modules.usecases.register.UserRegisterResponseDto;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class UserRegisterInteractorTest extends TestBase {

    @Mock
    private UserDsGateway gateway;
    @Mock
    private UserPresenter presenter;
    @Mock
    private UserFactory factory;

    private final Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    UserRegisterInteractor interactor;

    @BeforeEach
    void beforeEach() {
        interactor = new UserRegisterInteractor(gateway, presenter, factory, clock);
    }

    @Test
    void happyCase() {
        given(gateway.existsByName("baeldung"))
                .willReturn(false);
        given(factory.create("baeldung", "12345"))
                .willReturn(new CommonUser("baeldung", "12345"));
        given(gateway.save(new UserDsRequestDto("baeldung", "12345", LocalDateTime.now(clock))))
            .willReturn(new UserDsResponseDto(1L, "baeldung", LocalDateTime.now(clock)));

        interactor.register(new UserRegisterRequestDto("baeldung", "12345"));

        then(gateway).should()
                .save(new UserDsRequestDto("baeldung", "12345", LocalDateTime.now(clock)));
        then(presenter).should()
                .prepareSuccessView(new UserRegisterResponseDto(1L, "baeldung", LocalDateTime.now(clock).toString()));
    }
}
