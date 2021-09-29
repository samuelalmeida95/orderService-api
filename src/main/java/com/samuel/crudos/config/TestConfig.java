package com.samuel.crudos.config;

import com.samuel.crudos.services.DBservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

  @Autowired
  private DBservice dBservice;

  @Bean
  public void instanciaDB() {
    this.dBservice.instanciaDB();
  }
}
