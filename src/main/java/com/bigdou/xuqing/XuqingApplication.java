package com.bigdou.xuqing;

import com.bigdou.xuqing.dao.UserDao;
import com.bigdou.xuqing.datasource.DataSourceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@RestController
@Slf4j
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DataSourceManager.class}))
public class XuqingApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(XuqingApplication.class, args);
    }

    @RequestMapping("/test")
    public String test () {
        return "OK";
    }

    @Override
    public void run(String... args) throws Exception {
//        showConnection();
//        showData();
        userDao.findAll().forEach(row -> log.info(row.toString()));
    }

    private void showConnection() {
        log.info(dataSource.toString());
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            log.error("show Connection error ", e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM user").forEach(row -> log.info(row.toString()));
    }

}
