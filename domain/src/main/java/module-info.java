module java19modules.domain {
    requires jakarta.annotation;
    requires lombok;

    // Is only allowed to expose things and have minimal dependencies
    exports org.myshelf.java19modules.domain;
}