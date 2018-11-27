package com.si5.hrpayroll.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class LoginDAOConfig {
    @Bean(name="prds")
    @ConfigurationProperties("payroll-ds")
    public DataSource payrollDs() {
        return DataSourceBuilder.create().build() ;
    }

    @Bean(name="payrollTxnMgr")
    @Autowired
    DataSourceTransactionManager tm2(@Qualifier("prds") DataSource datasource) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
        return txm;
    }

    @Bean("payrollJdbc")
    @Autowired
    public JdbcTemplate getJdbcTemplate(@Qualifier("prds") DataSource ds) {
        return new JdbcTemplate(ds) ;
    }
}
