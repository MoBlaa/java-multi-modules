package org.myshelf.java19modules.domain;


import jakarta.annotation.Nullable;

public interface User {

    @Nullable
    String passwordIsValid();

    String getName();

    String getPassword();
}
