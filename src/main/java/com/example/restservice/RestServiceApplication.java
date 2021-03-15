package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RestServiceApplication {
  @Bean("writer1")
  public Writer getWriter1() {
    return new Writer("Writer 1");
  }

  @Bean("writer2")
  public Writer getWriter2() {
    return new Writer("Writer 2");
  }

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(RestServiceApplication.class, args);
    System.out.println("Application context initialized!!!");
    Writer writer1 = ctx.getBean("writer1", Writer.class);
    writer1.write("First message");

    Writer writer2 = ctx.getBean("writer2", Writer.class);
    writer2.write("Second message");
  }

}
