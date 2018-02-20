package com.example.wire.dao.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.hibernate.dialect.MySQL57InnoDBDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.example.wire.dao.repository")
public class DAOConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DAOConfiguration.class);

    @Value("${spring.datasource.driver-class-name}")
    private String datasourceClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private boolean showSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private boolean formatSql;

    @Value("${datasource.advancedLogger}")
    private boolean advancedLogger;

    @Value("${datasource.keepalive}")
    private String datasourceKeepaliveSql;

    @Value("${hibernate.databasePlatform}")
    private String databasePlatform;

    @Bean
    public HikariConfig getHikariConfig() {
        final HikariConfig hc = new HikariConfig();
        hc.setPoolName("wireCP");
        //hc.setConnectionTestQuery(datasourceKeepaliveSql);
        hc.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");

        final Properties props = new Properties();
        props.put("url", datasourceUrl);
        props.put("user", datasourceUsername);
        props.put("password", datasourcePassword);

        hc.setDataSourceProperties(props);
        return hc;
    }

    @Bean
    public DataSource getDataSource() {
        if (advancedLogger) {
            return new Log4jdbcProxyDataSource(new HikariDataSource(getHikariConfig()));
        } else {
            return new HikariDataSource(getHikariConfig());
        }
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(showSql);
        if (!databasePlatform.isEmpty()) {
            adapter.setDatabasePlatform(databasePlatform);
        } else {
            final Class<?> databaseDialectClass = determineDatabaseDialectClass(datasourceUrl);
            if (databaseDialectClass != null) {
                adapter.setDatabasePlatform(databaseDialectClass.getName());
            }
        }
        return adapter;
    }
    @Bean(name = "entityManagerFactory")
    @DependsOn("getDataSource")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean fb = new LocalContainerEntityManagerFactoryBean();
        fb.setDataSource(getDataSource());
        fb.setJpaVendorAdapter(getJpaVendorAdapter());
        fb.setPersistenceUnitName("Wire");
        fb.setPackagesToScan("com.example.wire.domain");

        final Properties props = new Properties();
        if (formatSql) {
            props.put("hibernate.format_sql", formatSql);
        }

        fb.setJpaProperties(props);

        return fb;
    }


    private static Class<?> determineDatabaseDialectClass(final String datasourceUrl) {
        if (StringUtils.startsWithIgnoreCase(datasourceUrl, "jdbc:mysql")) {
            return MySQL57InnoDBDialect.class;
        } else {
            LOGGER.warn("The database platform cannot be determined automatically from the data source URL");
            return null;
        }
    }

}
