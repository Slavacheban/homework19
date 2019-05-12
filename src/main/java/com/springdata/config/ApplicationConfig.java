package com.springdata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.springdata")
@EnableJpaRepositories("com.springdata.repository")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${driver}")
    private String driver;
    @Value("${password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${ddl-auto}")
    private String ddlAuto;
    @Value("${hibernate.show_sql}")
    private String showSQL;

    @Bean
    public DriverManagerDataSource DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }


}
