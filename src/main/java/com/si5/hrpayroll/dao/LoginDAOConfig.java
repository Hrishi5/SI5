package com.si5.hrpayroll.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class LoginDAOConfig {
    @Bean(name="pwds")
    @ConfigurationProperties("password-ds")
    public DataSource passwordDs() {
        String url = "jdbc:mysql://si5.ctskdrp2unsl.us-west-2.rds.amazonaws.com:3306/PassWordDetails" ;
        return DataSourceBuilder
                .create()
                .url(url)
                .username("admin")
                .password("Password-1")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    @Bean(name="prds")
    @ConfigurationProperties("payroll-ds")
    public DataSource prDs() {
        String url = "jdbc:mysql://si5.ctskdrp2unsl.us-west-2.rds.amazonaws.com:3306/PayRoll" ;
        return DataSourceBuilder
                .create()
                .url(url)
                .username("admin")
                .password("Password-1")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    @Bean(name="hrds")
    @ConfigurationProperties("hr-ds")
    public DataSource hrDs() {
        String url = "jdbc:mysql://si5.ctskdrp2unsl.us-west-2.rds.amazonaws.com:3306/HR" ;
        return DataSourceBuilder
                .create()
                .url(url)
                .username("admin")
                .password("Password-1")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();

    }

    @Bean(name="pwTxnMgr")
    @Autowired
    DataSourceTransactionManager tmpw(@Qualifier("pwds") DataSource datasource) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
        return txm;
    }

    @Bean(name="hrTxnMgr")
    @Autowired
    DataSourceTransactionManager tmhr(@Qualifier("hrds") DataSource datasource) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
        return txm;
    }

    @Bean(name="prTxnMgr")
    @Autowired
    DataSourceTransactionManager tmpr(@Qualifier("prds") DataSource datasource) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
        return txm;
    }

    @Bean("passwordJdbc")
    @Autowired
    public JdbcTemplate getPasswordJdbcTemplate(@Qualifier("pwds") DataSource ds) {
        return new JdbcTemplate(ds) ;
    }

    @Bean("hrJdbc")
    @Autowired
    public JdbcTemplate getHrJdbcTemplate(@Qualifier("hrds") DataSource ds) {
        return new JdbcTemplate(ds) ;
    }

    @Bean("payrollJdbc")
    @Autowired
    public JdbcTemplate getPayrollJdbcTemplate(@Qualifier("prds") DataSource ds) {
        return new JdbcTemplate(ds) ;
    }
}
