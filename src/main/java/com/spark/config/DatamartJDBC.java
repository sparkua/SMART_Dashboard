package com.spark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Spark on 3/20/16.
 */
@Configuration
public class DatamartJDBC {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@oqmdbuat.cscdev.com:1525/cvoqmt.cablevision.com";
    private static final String DB_USER = "dmtclmgr";
    private static final String DB_PASSWORD = "dmtclmgr_uat";

    @Bean(name = "dsOracle")
    public DataSource dataSource() {
        // instantiate, configure and return DataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_CONNECTION);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean(name = "jdbcOracle")
    public JdbcTemplate jdbcTemplate(DataSource dsOracle) {
        return new JdbcTemplate(dsOracle);
    }
}
