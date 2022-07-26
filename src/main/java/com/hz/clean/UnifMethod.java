package com.hz.clean;

import com.hz.entity.CheckItem;
import com.hz.entity.CheckResult;
import com.hz.entity.Report;
import com.hz.entity.ReportObj;

import java.util.ArrayList;
import java.util.function.Function;

public class UnifMethod {

    public Report stdReport(Report report) {
        report.getObj().getReportContent().getCheckItems().stream().map(
                checkItem -> {
                    checkItem.getCheckResults().stream().map(
                            checkResult -> {
                                String chkItemName = UnifCleanMethod.index_name_replace(checkItem.getCheckItemName());
                                String chkIndexName = UnifCleanMethod.index_name_replace(checkResult.getCheckIndexName());
                                if (UnifDbMethods.result.containsKey(chkItemName + chkIndexName)) {
                                    stdItems(chkItemName, chkIndexName, checkItem, checkResult);
                                }
                                return checkResult;
                            }
                    );
                    return checkItem;
                }
        );
        return report;
    }

    public void stdItems (String item, String index, CheckItem checkItem, CheckResult checkResult) {
        ArrayList<String> itemMap = UnifDbMethods.result.get(item + index);
        String stdItemName = itemMap.get(0);
        String stdIndexName = itemMap.get(1);
        String indexType = itemMap.get(2);
        String stdType = itemMap.get(3);
        checkItem.setStdCheckItemName(stdItemName);
        checkResult.setStdCheckIndexName(stdIndexName);
        checkResult.setCheckIndexType(indexType);
        checkResult.setStdType(stdType);
    }
}
