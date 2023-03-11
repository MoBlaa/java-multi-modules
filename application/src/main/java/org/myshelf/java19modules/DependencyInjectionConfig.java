package org.myshelf.java19modules;

import org.myshelf.java19modules.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class DependencyInjectionConfig {

    @Bean
    public UserFactory userFactory() {
        return new CommonUserFactory();
    }

    @Bean
    public UserInputBoundary inputBoundary(
            UserRegisterDsGateway gateway,
            UserPresenter presenter,
            UserFactory factory,
            Clock clock
    ) {
        return new UserRegisterInteractor(gateway, presenter, factory, clock);
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
