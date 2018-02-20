package com.example.wire.service.config;

import com.example.wire.dao.config.DAOConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Import(DAOConfiguration.class)
public class ServicesConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean(name = "transactionManager")
    public JpaTransactionManager getTransactionManager() {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
