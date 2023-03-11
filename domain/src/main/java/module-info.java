module java19modules.domain {
    requires jakarta.annotation;
    requires static lombok;

    exports org.myshelf.java19modules.domain;
    opens org.myshelf.java19modules.domain;
}