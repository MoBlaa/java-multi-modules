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
    requires static lombok;
    requires org.hibernate.orm.core;

    // requires deep reflection
    opens org.myshelf.java19modules;
    exports org.myshelf.java19modules;
    exports org.myshelf.java19modules.gateways;
    opens org.myshelf.java19modules.gateways;
    exports org.myshelf.java19modules.controllers;
    opens org.myshelf.java19modules.controllers;
    exports org.myshelf.java19modules.presenters;
    opens org.myshelf.java19modules.presenters;
}