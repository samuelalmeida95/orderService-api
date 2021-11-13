package com.samuel.crudos.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class PopulateDBCondition implements Condition {

    public static final String CREATE = "create";
    public static final String SPRING_JPA_HIBERNATE_DDL_AUTO = "spring.jpa.hibernate.ddl-auto";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        String ddlAuto = env.getProperty(SPRING_JPA_HIBERNATE_DDL_AUTO);
        return CREATE.equals(ddlAuto);
    }
}
