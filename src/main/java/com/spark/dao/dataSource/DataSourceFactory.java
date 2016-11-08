package com.spark.dao.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * Created by Spark on 2/18/16.
 */
@PropertySource(value = {"classpath:config.properties"})
public class DataSourceFactory extends JdbcDaoSupport {

    @Autowired
    private Environment environment;

    @Autowired
    private MapDataSourceLookup dataSourceMap;

    public JdbcTemplate getJdbcTemplate(String dataSourceName) {
        DataSource dataSource = null;
        try {
            dataSource = dataSourceMap.getDataSource(dataSourceName);
        } catch (DataSourceLookupFailureException e) {
            dataSource = createDataSource(
                    environment.getRequiredProperty("jdbc2.driverClassName"),
                    environment.getRequiredProperty("jdbc2.url"),
                    environment.getRequiredProperty("jdbc2.username"),
                    environment.getRequiredProperty("jdbc2.password")
            );
            dataSourceMap.addDataSource(dataSourceName, dataSource);
        }

        setJdbcTemplate(new JdbcTemplate(dataSource));

        return getJdbcTemplate();
    }

    public static DataSource createDataSource(String driverClass, String url, String username,
                                              String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,
                username, password);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
