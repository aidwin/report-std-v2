package com.hz.map;

import com.hz.clean.UnifMethod;
import com.hz.entity.CheckItem;
import com.hz.entity.Report;
import com.hz.utils.EmptyUtil;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class StdReportMapFunction extends RichMapFunction<Report,Report> {

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        System.out.println("map init");
    }

    @Override
    public void close() throws Exception {
        super.close();
        System.out.println("map close");
    }

    @Override
    public Report map(Report report) throws Exception {
        System.out.println("map map");
        long beginTime = System.currentTimeMillis();
//        1、删除CheckResults为空数据
        List<CheckItem> checkItems = report.getObj().getReportContent().getCheckItems();
        Iterator<CheckItem> iterator = checkItems.iterator();
        while (iterator.hasNext()) {
            CheckItem checkItem = iterator.next();
            if (EmptyUtil.isEmpty(checkItem.getCheckResults())){
                iterator.remove();
            }
        }
        report.getObj().getReportContent().setCheckItems(checkItems);
//      2、报告标准话处理

        report = new  UnifMethod().stdReport(report);
//        logger.info("标准化cost：{}ms", System.currentTimeMillis - beginTime)

        Report StdReport = new UnifMethod().stdReport(report);
        return StdReport;
    }
}
