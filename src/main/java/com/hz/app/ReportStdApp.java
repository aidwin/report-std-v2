package com.hz.app;


import com.hz.entity.Report;
import com.hz.map.StdReportMapFunction;
import com.hz.sink.EsSink;
import com.hz.source.KafkaSource;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch6.ElasticsearchSink;
import org.apache.http.HttpHost;

import java.util.ArrayList;

public class ReportStdApp {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(1000);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStreamSource dataStreamSource = env.addSource(new KafkaSource().getConsumer("a", "b", "192"));
//        map
        dataStreamSource.map(new StdReportMapFunction());

//        sink
        ArrayList<HttpHost> httpHosts = new ArrayList<>();
        httpHosts.add(new HttpHost("192.168.1.152",9200));
        httpHosts.add(new HttpHost("192.168.1.153",9200));
        dataStreamSource.addSink(new ElasticsearchSink.Builder<Report>(httpHosts,new EsSink()).build());
    }
}
