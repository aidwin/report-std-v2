package com.hz.config;

import com.hz.source.DruidDataSource;
import com.hz.utils.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConfig {
    Logger logger = LoggerFactory.getLogger(JdbcConfig.class);

    // private val originDataDB: String = Props.get("mysql.connection.url.origin_data")
    private String dataetlDB = Props.get("mysql.connection.url");
    private String password = Props.get("mysql.connection.password");
    private String user = Props.get("mysql.connection.user");
    //private lazy val originData: DataSource = new DataSource(originDataDB, user, password);
//    private  CtDataSource dataetl = new CtDataSource(dataetlDB, user, password);
    private static  DruidDataSource duridSource = new DruidDataSource();
    private  DruidDataSource duridKnowSource = new DruidDataSource();

    public JdbcConfig() throws Exception {
    }

    //  def getOriginDataConnection: Connection = {
//    return originData.getConnection
//  }
    public static Connection getDuridConnection(){
        try {
            return duridSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public Connection getDuridKnowConnection() throws SQLException {

        return duridSource.getKnowConnection();
    }
//
//    public Connection getDataetlConnection(){
//        return dataetl.getConnection();
//    }
}
