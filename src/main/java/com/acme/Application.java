package com.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Standard main class for Spring, generated by Spring template
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")

public class Application {

    /**
     * Maintain a reference to Spring's 'context' for our application.
     */
    private static ApplicationContext applicationContext=null;
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
    /**
     * Obtain lazy-int'ed reference to Spring's 'context' for our application.
     * @return
     */
    public static ApplicationContext getApplicationContext()
    {
        if (applicationContext == null)
        {
            applicationContext = new AnnotationConfigApplicationContext(Application.class);
        }
        return applicationContext;
    }
}
