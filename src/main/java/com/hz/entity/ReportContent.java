package com.hz.entity;

import java.util.List;

public class ReportContent {

    private List<String> generalSummarys2;

    private List<GeneralSummary> generalSummarys;

    private List<CheckItem> checkItems;

    public List<String> getGeneralSummarys2() {
        return generalSummarys2;
    }

    public void setGeneralSummarys2(List<String> generalSummarys2) {
        this.generalSummarys2 = generalSummarys2;
    }

    public List<GeneralSummary> getGeneralSummarys() {
        return generalSummarys;
    }

    public void setGeneralSummarys(List<GeneralSummary> generalSummarys) {
        this.generalSummarys = generalSummarys;
    }

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }
}
