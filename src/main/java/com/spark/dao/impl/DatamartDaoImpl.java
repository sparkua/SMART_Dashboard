package com.spark.dao.impl;

import com.spark.dao.DatamartDao;
import com.spark.dao.QueryConstants;
import com.spark.dao.model.StatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Spark on 4/28/16.
 */
@Repository
public class DatamartDaoImpl implements DatamartDao {

    @Autowired
    @Qualifier("jdbcOracle")
    protected JdbcTemplate jdbcTemplate;

    public List<StatModel> getStatistic(Integer numDays) {

        System.out.println("GetStatic" + numDays);

        List<StatModel> stat = jdbcTemplate.query(
                QueryConstants.GET_DATAMART_STAT,new Integer[]{numDays}, new BeanPropertyRowMapper(StatModel.class));
        System.out.println("Number of rows:" + stat.size());
        return stat;
    }

    public List<String> getDatamartProcList(){
        System.out.println("getDatamartProcList");

        List<String> procNameList = jdbcTemplate.query(
                QueryConstants.GET_DATAMART_PROC_LIST,new BeanPropertyRowMapper(String.class));

        return procNameList;
    }

}
