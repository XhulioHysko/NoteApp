package com.example.noteapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        // Load database properties
        Properties properties = new Properties();
        try (InputStream inputStream = HibernateUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("db.properties file not found in the classpath");
            }
            properties.load(inputStream);

            // Configure Hibernate using the loaded properties
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
            configuration.configure(); // Loads hibernate.cfg.xml automatically

            return configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading Hibernate configuration", e);
        }
    }
}
