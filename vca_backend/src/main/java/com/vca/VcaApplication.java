package com.vca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.vca.*")
@EntityScan(basePackages="com.vca.*")
@EnableJpaRepositories(basePackages="com.vca.*")

public class VcaApplication {

  public static void main(String[] args) {
    SpringApplication.run(VcaApplication.class, args);
  }
}