package com.hz.entity;

import java.util.List;

public class CheckItem {

    private String departmentName;

    private List<CheckResult> checkResults;

    private String salePrice;

    private String checkUserName;

    private String checkStateId;

    private String stdCheckItemName;

    private String checkItemName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<CheckResult> getCheckResults() {
        return checkResults;
    }

    public void setCheckResults(List<CheckResult> checkResults) {
        this.checkResults = checkResults;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getCheckStateId() {
        return checkStateId;
    }

    public void setCheckStateId(String checkStateId) {
        this.checkStateId = checkStateId;
    }

    public String getStdCheckItemName() {
        return stdCheckItemName;
    }

    public void setStdCheckItemName(String stdCheckItemName) {
        this.stdCheckItemName = stdCheckItemName;
    }

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }
}
