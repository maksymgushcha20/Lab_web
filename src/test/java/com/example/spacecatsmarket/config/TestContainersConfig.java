package com.example.spacecatsmarket.config;

import org.testcontainers.containers.MySQLContainer;

public class TestContainersConfig {
    private static final MySQLContainer<?> MYSQL_CONTAINER;

    static {
        MYSQL_CONTAINER = new MySQLContainer<>("mysql:8.1")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        MYSQL_CONTAINER.start();

        System.setProperty("jdbc:mysql://localhost:3306/mydb", MYSQL_CONTAINER.getJdbcUrl());
        System.setProperty("root", MYSQL_CONTAINER.getUsername());
        System.setProperty("root", MYSQL_CONTAINER.getPassword());
    }
}
