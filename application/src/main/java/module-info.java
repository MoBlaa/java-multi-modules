module java19modules.application {
    requires java19modules.domain;

    requires spring.core;
    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.context;
    requires spring.beans;
    requires jakarta.persistence;
    requires lombok;

    // requires deep reflection
    opens org.myshelf.java19modules to spring.core;
    exports org.myshelf.java19modules to spring.beans,spring.context;
}