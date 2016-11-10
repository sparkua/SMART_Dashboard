package com.spark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Spark on 6/28/16.
 */
@Configuration
public class LocalJDBC {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@oqmdbuat.cscdev.com:1525/cvoqmt.cablevision.com";
    private static final String DB_USER_LOCAL = "worldmgr";
    private static final String DB_PASSWORD = "world_uat";

    @Bean(name = "dsLocal")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_CONNECTION);
        dataSource.setUsername(DB_USER_LOCAL);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean(name = "jdbcLocal")
    public JdbcTemplate jdbcTemplate(DataSource dsOracle) {
        return new JdbcTemplate(dsOracle);
    }
}
