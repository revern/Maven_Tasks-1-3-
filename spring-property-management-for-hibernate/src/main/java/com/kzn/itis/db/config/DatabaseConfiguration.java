package com.kzn.itis.db.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class DatabaseConfiguration {

    @Value("${hibernate.db.url}")
    private String dbUrl;

    @Value("${hibernate.db.user}")
    private String dbUser;

    @Value("${hibernate.db.password}")
    private String dbPassword;

    @Value("${hibernate.hbm2ddl.auto.init-param}")
    private String dbHbm2ddl;

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbHbm2ddl() {
        return dbHbm2ddl;
    }
}
