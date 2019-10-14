package com.luv2code.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

//This is spring-mvc-servlet.xml
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    // define a bean for ViewResolver
    // set up a logger for diagnostics

    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource dataSource() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //comboPooledDataSource.setDataSourceName("com.mysql.cj.jdbc.MysqlDataSource");
        try {
            String driverClass = environment.getProperty("Dname");
            comboPooledDataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException exc) {

            throw new RuntimeException(exc);
        }
        String userName = environment.getProperty("Uname");
        String password = environment.getProperty("password");
        String url = environment.getProperty("URL");
        int minPoolSize = Integer.parseInt(environment.getProperty("connection.pool.minPoolSize"));
        int maxPoolSize = Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize"));
        int maxIdleTime = Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime"));
        int initialPoolSize = Integer.parseInt(environment.getProperty("connection.pool.intialPoolSize"));
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setMinPoolSize(minPoolSize);
        comboPooledDataSource.setInitialPoolSize(initialPoolSize);
        comboPooledDataSource.setMaxPoolSize(maxPoolSize);
        comboPooledDataSource.setMaxIdleTime(maxIdleTime);
        return comboPooledDataSource;
    }

}









