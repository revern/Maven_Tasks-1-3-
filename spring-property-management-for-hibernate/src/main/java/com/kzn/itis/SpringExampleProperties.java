package com.kzn.itis;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.UserRepository;
import com.kzn.itis.db.repositories.impl.UserRepositoryImpl;
import com.kzn.itis.db.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class SpringExampleProperties {

    private static final Logger logger = LoggerFactory.getLogger(SpringExampleProperties.class);

    @Autowired
    private DatabaseConfiguration config;

    public DatabaseConfiguration getConfig() {
        return config;
    }

    public void setConfig(DatabaseConfiguration config) {
        this.config = config;
    }

    public void run() {
        logger.info("Welcome to Example Application");
        logger.info("url=" + config.getDbUrl());
        logger.info("username=" + config.getDbUser());

        Map<String, Object> configOverrides = new HashMap<String, Object>();
        configOverrides.put("hibernate.connection.url", config.getDbUrl());
        configOverrides.put("hibernate.connection.username", config.getDbUser());
        configOverrides.put("hibernate.connection.password", config.getDbPassword());
        configOverrides.put("hibernate.hbm2ddl.auto", config.getDbHbm2ddl());
        SessionUtil.getEntityManagerFactory(configOverrides);

        // Repeat the old code from maven-resources-in-hibernate Example
        testDB();
    }

    protected void testDB() {
        UserRepository userRepository = new UserRepositoryImpl();

        User user = new User();
        user.setAge(35);
        user.setFirstname("Sherlock");
        user.setLastname("Holmes");

        userRepository.addUser(user);

        logger.info("User has been added!");

        long count = userRepository.getCount();

        logger.info("New count: " + String.valueOf(count));
    }

    public static void main(String... args) throws SQLException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SpringExampleProperties main = (SpringExampleProperties)context.getBean("exampleApp");
        main.run();
    }
}
