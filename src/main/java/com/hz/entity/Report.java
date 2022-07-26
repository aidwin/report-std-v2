package com.hz.entity;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import scala.beans.BeanProperty;

public class Report {

    @BeanProperty
    @JsonProperty("eventType")
    private String eventType = "";

    @BeanProperty
    @JsonProperty("table")
    private String table = "";

    @BeanProperty
    @JsonProperty("obj")
    private ReportObj obj=null;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public ReportObj getObj() {
        return obj;
    }

    public void setObj(ReportObj obj) {
        this.obj = obj;
    }
}
