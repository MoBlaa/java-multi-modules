package org.myshelf.java19modules.domain;

import jakarta.annotation.Nullable;

public class CommonUserFactory implements UserFactory {
    @Override
    @Nullable
    public User create(String name, String password) {
        return new CommonUser(name, password);
    }
}
