package com.hz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import static com.hz.utils.ScalaUtils.readFile;

public  class Props {

   static Logger logger = LoggerFactory.getLogger(Props.class);

    public static Properties prop = new Properties();

    {
//   prop.load(ScalaUtils.readFile("/data/flink/jobs/report_std/conf/config.properties"))
        try {
            prop.load(ScalaUtils.readFile("/Users/macos/Documents/haozhuo数据/guoch/workhouse/flink-report-std/report-std/src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //prop.load(ScalaUtils.readFile("hdfs://datagcluster/flink/flink-data-etl/article-rcmd/config.properties"))
//    prop.load(ScalaUtils.readFile("/hadoop/haozhuo/flink-1.7.1/job/std_report/config/config.properties"))
    }



    /**
     * 根据配置文件中的的属性名获取属性值
     */
    public static String get(String propertyName) throws UnsupportedEncodingException {
        String value = prop.getProperty(propertyName);
        if (value == null) {
            logger.warn("config.properties文件中沒有这个属性:{}" , propertyName);
            value = "";
        }
      return   new String(value.getBytes("ISO-8859-1"), "utf-8");
    }

    public static String get(String propertyName,String defaultValue) throws UnsupportedEncodingException {
        String value = prop.getProperty(propertyName);
        if (value == null) {
             return    value = defaultValue;
        }
       return new String(value.getBytes("ISO-8859-1"), "utf-8");
    }

    public static void main(String[] args) {
        System.out.println(Props.class.getResource("/config.properties").getPath());
    }
}
