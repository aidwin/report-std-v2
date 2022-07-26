package com.hz.sink;

import com.alibaba.fastjson.JSON;
import com.hz.entity.Report;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch6.ElasticsearchSink;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EsSink implements ElasticsearchSinkFunction<Report> {

    @Override
    public void process(Report report, RuntimeContext runtimeContext, RequestIndexer requestIndexer) {
        HashMap newjsonMap = new HashMap<String,Object>();
//        Map newjsonMap = JSON.parseObject(JSON.toJSONString(report), Map.class);
        newjsonMap.put("health_report_id",report.getObj().getHealthReportId());
        newjsonMap.put("create_date",report.getObj().getReportCreateTime().substring(0,10));
        newjsonMap.put("idcard", report.getObj().getIdCardNoMd5());
        newjsonMap.put("userId",report.getObj().getUserId());
        newjsonMap.put("sex",report.getObj().getSex());
        newjsonMap.put("name",report.getObj().getName());
        newjsonMap.put("dwdm",report.getObj().getDwdm());
        newjsonMap.put("dwmc",report.getObj().getDwmc());
        newjsonMap.put("checkDate",report.getObj().getCheckDate());
        newjsonMap.put("age",report.getObj().getAge());
        newjsonMap.put("birtday",report.getObj().getBirthday());
        newjsonMap.put("userLoadTiem",report.getObj().getUserLoadTime());
        newjsonMap.put("report_create_time",report.getObj().getReportCreateTime());
        newjsonMap.put("report_content", JSON.toJSON(report.getObj().getReportContent()));
        newjsonMap.put("etl_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        IndexRequest indexRequest = Requests.indexRequest()
                .index("")
                .type("")
                .source(newjsonMap)
                .id(report.getObj().getHealthReportId());
        requestIndexer.add(indexRequest);
    }
}
