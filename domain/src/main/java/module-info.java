module java19modules.domain {
  requires jakarta.annotation;
  requires static lombok;

  exports org.myshelf.java19modules.domain;

  opens org.myshelf.java19modules.domain;

  exports org.myshelf.java19modules.usecases.register;

  opens org.myshelf.java19modules.usecases.register;

  exports org.myshelf.java19modules.gateways.users;

  opens org.myshelf.java19modules.gateways.users;

  exports org.myshelf.java19modules.presenters.users;

  opens org.myshelf.java19modules.presenters.users;
}
