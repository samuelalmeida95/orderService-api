package com.samuel.crudos.config;

import com.samuel.crudos.services.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

  @Autowired
  private DBservice dBservice;

  @Bean("instanciaDBDev")
  @Conditional(PopulateDBCondition.class)
  public void instanciaDB() {
    this.dBservice.instanciaDB();
  }
}
