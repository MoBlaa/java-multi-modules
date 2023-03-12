package org.myshelf.java19modules;

import org.myshelf.java19modules.domain.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.time.Clock;

@Configuration
@ComponentScan(basePackages = "org.myshelf.java19modules",
    excludeFilters = @ComponentScan.Filter(pattern = "org.myshelf.java19modules.domain"))
public class DependencyInjectionConfig {

    @Bean
    public BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
        return beanFactory -> genericApplicationContext(
                (BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry)
        .getBeanFactory());
    }

    void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan("com.baeldung.pattern.cleanarchitecture");
    }

    static TypeFilter removeModelAndEntitiesFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) ->
            !mr.getClassMetadata().getClassName().endsWith("Dto")
            && (mr.getClassMetadata().getClassName().endsWith("Boundary")
            || mr.getClassMetadata().getClassName().endsWith("Factory")
            || mr.getClassMetadata().getClassName().endsWith("Gateway")
            || mr.getClassMetadata().getClassName().endsWith("Interceptor"));
    }

//    @Bean
//    public UserFactory userFactory() {
//        return new CommonUserFactory();
//    }
//
//    @Bean
//    public UserInputBoundary inputBoundary(
//            UserRegisterDsGateway gateway,
//            UserPresenter presenter,
//            UserFactory factory,
//            Clock clock
//    ) {
//        return new UserRegisterInteractor(gateway, presenter, factory, clock);
//    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
