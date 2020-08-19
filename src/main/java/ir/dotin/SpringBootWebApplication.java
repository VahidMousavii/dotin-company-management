package ir.dotin;

import ir.dotin.initialize.CategoryInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
        wholeInitialize();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void wholeInitialize(){
        CategoryInitializer categoryInitializer = CategoryInitializer.get();
        categoryInitializer.addPersonRoleCategory();
        categoryInitializer.addStatusOfRequest();
        categoryInitializer.addTypeOfRequestCategory();
    }

}