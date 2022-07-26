package com.hz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ScalaUtils {


   static Logger logger = LoggerFactory.getLogger(ScalaUtils.class);


    public static InputStream readFile(String path) throws FileNotFoundException {
        InputStream in = null;
        String hdfsPartten = "hdfs://[0-9a-zA_Z.:]+/";
        boolean matches = Pattern.matches(hdfsPartten, path);
        if (matches) {
            logger.info("加载HDFS中的文件:{}", path);
            //      val hadoopConf = new org.apache.hadoop.conf.Configuration()
            //      val hdfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(reg.get), hadoopConf)
            //      in = hdfs.open(new org.apache.hadoop.fs.Path(path)).asInstanceOf[java.io.InputStream]
        } else {
            logger.info("加载本地目录下的文件:{}", path);
            in = new FileInputStream(path);
        }
        return in;
    }

    public String toString(Object object){
        if (object == null){
            return "";
        } else {
            return object.toString();
        }
    }

    public int toInt(Object obj) {
        if (obj == null)
            return 0;
        else {
            return Integer.parseInt(obj.toString());
        }
    }

    public Double toDouble(Object obj) {
        if (obj == null)
            return 0D;
        else {
            return Double.parseDouble(obj.toString());
        }
    }

    public Double firstItrAsDouble(Iterable iter) {
        Iterator<Double> iterator = iter.iterator();
        if (iterator.hasNext()) {
           return retainDecimal(iterator.next(), 2);
        } else {
            return 0D;
        }
    }




    /**
     * 保留小数位数
     */
    public Double retainDecimal( Double number,  int bits) {
        bits = 2;
        return new BigDecimal(number).setScale(bits, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public Double retainDecimalDown(Double number,int bits) {
        bits = 2;
        return  new BigDecimal(number).setScale(bits, BigDecimal.ROUND_DOWN).doubleValue();
    }

    public String getStrDate(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

    public String  getStrDate(){
        return getStrDate("yyyy-MM-dd HH:mm:ss");
    }
}
