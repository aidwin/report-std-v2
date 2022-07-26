package com.hz.clean;

import org.slf4j.LoggerFactory;

public class UnifCleanMethod {
    private UnifCleanMethod() {
    }

    //异常名称清洗
    private String not_needed_symbols_replace_pattern =  "[\\s+`~!@#$%^&*()=|{}'\\[\\].。<>/?！￥…（）—\\-【】 ‘;；:：”“’,，、？\\\\]";
    //阴阳性结果匹配模式
    private String positive_or_negative_match_pattern1 = "^[+-]+(/(hp|HP))?$.*";
    private String positive_or_negative_match_pattern_2 = "^[\\d-]+/(hp|HP)$.*";
    private String positive_or_negative_match_pattern_3 = "^(hp|HP|弱|强)?[阴阳]性+.*";

    //数值型指标项检查结果
    private String numeric_chk_item_value_pattern = "^[0-9]+[0-9Ee.]+([↓↑]?(\\([\u4e00-\u9fa5,*].*?\\))?|次/分|(mmol|umol|CELL|g)/u?L)?$";
//    private String numeric_chk_item_value_pattern = """^[0-9]+[0-9Ee.]+([↓↑]?(\([\u4e00-\u9fa5,*].*?\))?|次/分|(mmol|umol|CELL|g)/u?L)?$""";

    // 非数字字符
    private String non_decimal = "[^\\d.]+";

    // 匹配汉字
    private String match_unicode = "[\u4e00-\u9fa5]";

    private String text_ref_replace_pattern1 = "^(->|>=|〉|>|﹥|＞|≥)";
    private String text_ref_replace_pattern2 = "^(-<=|-<|-＜|<=|<|＜|<)";
    private String text_ref_replace_pattern3 = "^(-\\d)";
    private String text_ref_replace_pattern4 = "-<=|-＜=|-<|-≤|-＜|<=|＜=|≤|<|＜|〈|〈";
    private String text_ref_replace_pattern5 = "-≤|->|~~|\\-\\-|~|～|－";
    private String text_ref_replace_pattern6 = "(^[0-9]\\d*$)|(^[0-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$)";


    /**
     * 异常名称清洗
     * @param abn_name
     * @return
     */
    private String clean_abn_name(String abn_name) {
        abn_name.replaceAll(not_needed_symbols_replace_pattern,"")
                .replaceAll("Ⅰ", "1")
                .replaceAll("Ⅱ", "2")
                .replaceAll("Ⅲ", "3")
                .toLowerCase();
        return  abn_name;
    }




    /**
     * checkItemName，checkIndexName 用以下函数对特殊字符处理
     * @param index_name1
     * @return
     */
    public static   String index_name_replace(String index_name1)  {
        String index_name = index_name1;
        if("".equals(index_name)){
            index_name = index_name.replace(" ", "").toUpperCase();
            index_name = index_name.replace("*", "");
            index_name = index_name.replace("【", "[").replace("】", "]");
            index_name = index_name.replace("（", "(").replace("）", ")");
            index_name = index_name.replace("[", "(").replace("]", ")");
            index_name = index_name.replace("—", "-").replace("－", "-").replace("--", "-");
            index_name = index_name.replace("_", "-");
            index_name = index_name.replace("★", "");
            index_name = index_name.replace("Ⅰ", "I");
            index_name = index_name.replace("Ⅱ", "II");
            index_name = index_name.replace(" ","");
            index_name = index_name.replace("\t","");
            index_name = index_name.replace("\n","");
            if ("-".equals(String.valueOf(index_name.charAt(0)))) {
                index_name = index_name.substring(1, index_name.length());
            }
            if (!"".equals(index_name)){
                if (".".equals(String.valueOf(index_name.charAt(index_name.length()-1)))){
                    index_name = index_name.substring(0, index_name.length() - 1);
                }
            }
        }
        return index_name;
    }
}
