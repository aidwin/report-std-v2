package com.hz.clean;

import com.hz.config.JdbcConfig;
import com.hz.source.DruidDataSource;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UnifDbMethods {
    public static HashMap<String, ArrayList<String>> result;
    static Logger logger = LoggerFactory.getLogger(UnifDbMethods.class);

    public static HashMap<String,ArrayList<String>> queryItemIndexNameMysql() throws SQLException {
        logger.info("加载标准化映射表：index_map");
        String index_name = "";
        String item_name = "";
        String index_type = "";
        String std_item_name = "";
        String std_index_name = "";
        String std_type = "";
        HashMap<String, ArrayList<String>> indexMap = new HashMap<>();
        Connection conn  = null;
        PreparedStatement preparedStmt = null;
        try {
            conn = JdbcConfig.getDuridConnection();
            //val resultSet2 = conn.createStatement().executeQuery("select * from check_index_name_map ;")
            
            preparedStmt = conn.prepareStatement("select index_name,item_name,index_type,std_index_name,std_item_name,std_type from check_index_name_map ");
            //preparedStmt = conn.prepareStatement("select * from check_index_name_map ;")
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<String> strings = new ArrayList<>(4);
                index_name = resultSet.getString("index_name").trim();
                item_name = resultSet.getString("item_name").trim();
                index_type = resultSet.getString("index_type").trim();
                std_index_name = resultSet.getString("std_index_name").trim();
                std_item_name = resultSet.getString("std_item_name").trim();
                if( resultSet.getString("std_type") ==null){
                    std_type="";
                }else{
                    std_type = resultSet.getString("std_type").trim();
                }
                strings.add(0,std_item_name);
                strings.add(1,std_item_name);
                strings.add(2,std_item_name);
                strings.add(3,std_item_name);
                indexMap.put(item_name+index_name,strings);
            }

        } catch (Exception e){
            logger.error("加载index_map Error", e.getMessage());
        } finally {
            DruidDataSource.close(preparedStmt, conn);
        }
        return indexMap;
    }
}
