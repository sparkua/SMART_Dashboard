package com.spark.dao.impl;

import com.spark.dao.StatisticExtDao;
import com.spark.dao.model.DatamartStat;
import com.spark.dao.model.Menu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Spark on 2/18/16.
 */
@Repository("statisticExtDao")
public class StatisticsExtDaoImpl  implements StatisticExtDao{
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void getDatamartStatistic() {
        /**
         * Specify the statement
         */
        String query = "INSERT INTO FORUMS (FORUM_ID, FORUM_NAME, FORUM_DESC) VALUES (?,?,?)";
        /**
         * Specify the values
         */
        jdbcTemplate.query("select id, name2 from data", new ActorMapper());


//        jdbcTemplate.update(query, new Object[]{Integer.valueOf(forum.getForumId()),
//                forum.getForumName(), forum.getForumDesc()});
    }

    private static final class ActorMapper implements RowMapper<Menu> {
        public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
            Menu stat = new Menu();
            stat.setId(rs.getInt(1));
            stat.setName(rs.getString("name2"));
            return stat;
        }
    }
}
