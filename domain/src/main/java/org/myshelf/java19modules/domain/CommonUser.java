package org.myshelf.java19modules.domain;

import jakarta.annotation.Nullable;

public class CommonUser implements User {

    private final String name;
    private final String password;

    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    @Nullable
    public String passwordIsValid() {
        if (password == null) {
            return "Password required";
        }
        if (password.length() < 5) {
            return "Password has to be at least 5 characters long";
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
