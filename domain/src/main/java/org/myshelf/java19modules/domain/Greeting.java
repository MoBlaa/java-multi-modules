package org.myshelf.java19modules.domain;

public record Greeting(String name) {

    @Override
    public String toString() {
        return "Hello, %s!".formatted(name);
    }
}
