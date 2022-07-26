package com.hz.entity;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import scala.Serializable;
import scala.beans.BeanProperty;

public class ReportObj implements Serializable {

        @BeanProperty
        @JsonProperty("healthReportId")
        private String healthReportId = "";
        @BeanProperty
        @JsonProperty("age")
        private Integer age = 0;
        @BeanProperty
        @JsonProperty("name")
        private String name = "";
        @BeanProperty
        @JsonProperty("userId")
        private String userId = "";
        @BeanProperty
        @JsonProperty("idCardNoMd5")
        private String idCardNoMd5 = "";
        @BeanProperty
        @JsonProperty("birthday")
        private String birthday = "";
        @BeanProperty
        @JsonProperty("sex")
        private String sex = "";
        @BeanProperty
        @JsonProperty("checkUnitCode")
        private String checkUnitCode = "";
        @BeanProperty
        @JsonProperty("checkUnitName")
        private String checkUnitName = "";
        @BeanProperty
        @JsonProperty("reportContent")
        private ReportContent reportContent = null;
        @BeanProperty
        @JsonProperty("checkDate")
        private String checkDate = "";
        @BeanProperty
        @JsonProperty("dwdm")
        private String dwdm = "";
        @BeanProperty
        @JsonProperty("dwmc")
        private String dwmc = "";
        @BeanProperty
        @JsonProperty("userLoadTime")
        private String userLoadTime = "";
        @BeanProperty
        @JsonProperty("reportCreateTime")
        private String reportCreateTime = "";
        @BeanProperty
        @JsonProperty("lastUpdateTime")
        private String lastUpdateTime = "";
        @BeanProperty
        @JsonProperty("addReportTime")
        private String addReportTime = "";

        public String getHealthReportId() {
                return healthReportId;
        }

        public void setHealthReportId(String healthReportId) {
                this.healthReportId = healthReportId;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public String getIdCardNoMd5() {
                return idCardNoMd5;
        }

        public void setIdCardNoMd5(String idCardNoMd5) {
                this.idCardNoMd5 = idCardNoMd5;
        }

        public String getBirthday() {
                return birthday;
        }

        public void setBirthday(String birthday) {
                this.birthday = birthday;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public String getCheckUnitCode() {
                return checkUnitCode;
        }

        public void setCheckUnitCode(String checkUnitCode) {
                this.checkUnitCode = checkUnitCode;
        }

        public String getCheckUnitName() {
                return checkUnitName;
        }

        public void setCheckUnitName(String checkUnitName) {
                this.checkUnitName = checkUnitName;
        }

        public ReportContent getReportContent() {
                return reportContent;
        }

        public void setReportContent(ReportContent reportContent) {
                this.reportContent = reportContent;
        }

        public String getCheckDate() {
                return checkDate;
        }

        public void setCheckDate(String checkDate) {
                this.checkDate = checkDate;
        }

        public String getDwdm() {
                return dwdm;
        }

        public void setDwdm(String dwdm) {
                this.dwdm = dwdm;
        }

        public String getDwmc() {
                return dwmc;
        }

        public void setDwmc(String dwmc) {
                this.dwmc = dwmc;
        }

        public String getUserLoadTime() {
                return userLoadTime;
        }

        public void setUserLoadTime(String userLoadTime) {
                this.userLoadTime = userLoadTime;
        }

        public String getReportCreateTime() {
                return reportCreateTime;
        }

        public void setReportCreateTime(String reportCreateTime) {
                this.reportCreateTime = reportCreateTime;
        }

        public String getLastUpdateTime() {
                return lastUpdateTime;
        }

        public void setLastUpdateTime(String lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
        }

        public String getAddReportTime() {
                return addReportTime;
        }

        public void setAddReportTime(String addReportTime) {
                this.addReportTime = addReportTime;
        }
}
