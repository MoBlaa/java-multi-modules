package org.myshelf.java19modules.domain;

import jakarta.annotation.Nullable;

public class CommonUserFactory implements UserFactory {
  @Override
  public @Nullable User create(String name, String password) {
    return new CommonUser(name, password);
  }
}
