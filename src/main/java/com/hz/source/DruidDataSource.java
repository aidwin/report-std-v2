package com.hz.source;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.hz.utils.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DruidDataSource.class);
    //private ComboPooledDataSource cpds;
    private DataSource dataSource;
    private DataSource knowDataSource;

    public DruidDataSource()  {
        Properties properties = new Properties();
        //properties.load(DruidDataSource.class.getClassLoader().getResourceAsStream("/data/flink/jobs/report_std/conf/druid.properties"));
        //String usl = Thread.currentThread().getContextClassLoader().getResource("druid.properties").getFile();
        //System.out.println("路径"+usl);
        //File file = new File("D:\\workSpace\\report-std\\src\\main\\resources\\druid.properties");
        //File file = new File("/Users/haozhuo/Desktop/CAIYT/git/flink-report-std/report-std/src/main/resources/druid.properties");
        try {
            File file = new File(Props.get("mysql.druid.path"));
            properties.load(new FileInputStream(file));
            dataSource = DruidDataSourceFactory.createDataSource(Props.prop);
            knowDataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
    public Connection getKnowConnection() throws SQLException {
        return this.knowDataSource.getConnection();
    }
    public static void close(PreparedStatement preparedStmt, Connection conn) {
        if (preparedStmt != null) {
            try {
                preparedStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
