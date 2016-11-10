package com.spark.dao.impl;

import com.spark.dao.LocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Spark on 6/28/16.
 */
public class LocalDaoImpl implements LocalDao {

    @Autowired
    @Qualifier("jdbcLocal")
    protected JdbcTemplate jdbcTemplate;

}
