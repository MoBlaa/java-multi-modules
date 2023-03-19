package org.myshelf.java19modules;

import java.time.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
  @Bean
  public Clock clock() {
    return Clock.fixed(Instant.now(), ZoneId.systemDefault());
  }
}
