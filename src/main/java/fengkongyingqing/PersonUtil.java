/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package fengkongyingqing;

import com.alibaba.fastjson.JSON;
import com.google.gson.annotations.JsonAdapter;
import com.netty08.Person;
import org.apache.commons.lang3.StringEscapeUtils;
import org.bson.types.BSONTimestamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName: PersonUtil.java
 * @Description: PersonUtil.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/31 9:49
 */
public abstract class PersonUtil {
    public abstract boolean add(List<Person> list);

    public static void main(String[] args) {
        String json = "{\"ICR_PIM_BASEINFO\":[{\"POSTADDRESS\":\"河北省张家口市桥东区胜利北路51号\",\"REPORTNO\":\"2020022220531014465915\",\"GENDER_NAME\":\"女\",\"REGISTEREDADDRESS\":\"北京市丰台区为南路52号院内1号\",\"EDUDEGREE_NAME\":\"--\",\"COUNTRY_NAME\":\"中国\",\"EMAIL\":\"--\",\"WORKSTATUS_NAME\":\"在职\",\"BIRTHDAY\":\"1987.05.09\",\"EDULEVEL_NAME\":\"本科\"}],\"ICR_PRH_BASEINFO\":[{\"CERTNO\":\"13010219870509412\",\"REPORTNO\":\"2020022220531014465915\",\"REPORTTIME\":\"2020.02.22 20:53:10\",\"QUERYORG_NAME\":\"张家口银行股份有限公司\",\"QUERYREASON_NAME\":\"信用卡审批\",\"NAME\":\"张某\",\"CERTTYPE_NAME\":\"身份证\"}],\"ICR_PCO_UNCYCLEACCOUNT\":[{\"CREDITLIMIT\":893549.0,\"ACCOUNTCOUNT\":3,\"ORGCOUNT\":3,\"REPORTNO\":\"2020022220531014465915\",\"LASTER6MONTHUSEDAVGAMOUNT\":8603.0,\"BALANCE\":764579.0}],\"ICR_PCO_OVERDUE\":[{\"HIGHESTOVERDUEAMOUNTPERMON\":1000,\"ACCOUNTCOUNT\":1,\"MAXDURATION\":5,\"MONTHS\":1},{\"HIGHESTOVERDUEAMOUNTPERMON\":1000,\"ACCOUNTCOUNT\":2,\"MAXDURATION\":3,\"MONTHS\":2},{\"HIGHESTOVERDUEAMOUNTPERMON\":1000,\"ACCOUNTCOUNT\":3,\"MAXDURATION\":1,\"MONTHS\":3}],\"ICR_PCO_CREDITTRADE\":[{\"BIGBUSINESSTYPE_NAME\":\"贷款\",\"REPORTNO\":\"2020022220531014465915\",\"FIRSTOPENMONTH\":\"--\",\"COUNT\":\"2\",\"BUSINESSTYPE_NAME\":\"个人住房贷款\"},{\"BIGBUSINESSTYPE_NAME\":\"贷款\",\"REPORTNO\":\"2020022220531014465915\",\"FIRSTOPENMONTH\":\"--\",\"COUNT\":\"2\",\"BUSINESSTYPE_NAME\":\"个人商用房贷款（包括商住两用房）\"},{\"BIGBUSINESSTYPE_NAME\":\"贷款\",\"REPORTNO\":\"2020022220531014465915\",\"FIRSTOPENMONTH\":\"2017.02\",\"COUNT\":\"3\",\"BUSINESSTYPE_NAME\":\"其他类贷款\"},{\"BIGBUSINESSTYPE_NAME\":\"信用卡\",\"REPORTNO\":\"2020022220531014465915\",\"FIRSTOPENMONTH\":\"2006.05\",\"COUNT\":\"18\",\"BUSINESSTYPE_NAME\":\"贷记卡\"},{\"BIGBUSINESSTYPE_NAME\":\"信用卡\",\"REPORTNO\":\"2020022220531014465915\",\"FIRSTOPENMONTH\":\"--\",\"COUNT\":\"--\",\"BUSINESSTYPE_NAME\":\"准贷记卡\"},{\"BIGBUSINESSTYPE_NAME\":\"其他\",\"REPORTNO\":\"2020022220531014465915\",\"FIRSTOPENMONTH\":\"--\",\"COUNT\":\"--\",\"BUSINESSTYPE_NAME\":\"--\"}],\"ICR_PHF_HOUSEFUND\":[{\"STATE_NAME\":\"缴交\",\"COMPERCENT\":12.0,\"REPORTNO\":\"2020022220531014465915\",\"OWNPERCENT\":12.0,\"AREA_NAME\":\"北京市东城区\",\"FIRSTMONTH\":\"--\",\"TOMONTH\":\"2020.01\",\"PAY\":1306.0,\"REGISTERDATE\":\"2015.10.28\",\"GETTIME\":\"2020.01\",\"ORGANNAME\":\"北京思诺顺源管理咨询有限公司\"},{\"STATE_NAME\":\"销户\",\"COMPERCENT\":12.0,\"REPORTNO\":\"2020022220531014465915\",\"OWNPERCENT\":12.0,\"AREA_NAME\":\"北京市东城区\",\"FIRSTMONTH\":\"--\",\"TOMONTH\":\"2016.05\",\"PAY\":832.0,\"REGISTERDATE\":\"2009.11.24\",\"GETTIME\":\"2016.05\",\"ORGANNAME\":\"中建一局集团第二建筑有限公司\"}],\"ICR_PDA_FIVEHISTORYDISPLAY\":[{\"MONTHS\":\"2018-1\",\"ACCOUNTTYPE_NAME\":\"非循环贷账户\",\"REPORTNO\":\"2020022220531014465915\",\"PAYBACKTYPE_NAME\":\"1\",\"ACCOUNTID\":\"1\",\"OVERDUEAMOUNTTOTAL\":1.0},{\"MONTHS\":\"2018-1\",\"ACCOUNTTYPE_NAME\":\"非循环贷账户\",\"REPORTNO\":\"2020022220531014465915\",\"PAYBACKTYPE_NAME\":\"2\",\"ACCOUNTID\":\"1\",\"OVERDUEAMOUNTTOTAL\":3.0},{\"MONTHS\":\"2018-1\",\"ACCOUNTTYPE_NAME\":\"非循环贷账户\",\"REPORTNO\":\"2020022220531014465915\",\"PAYBACKTYPE_NAME\":\"3\",\"ACCOUNTID\":\"1\",\"OVERDUEAMOUNTTOTAL\":4.0}],\"ICR_POM_PROFESSION\":[{\"EMPLOYERADDRESS\":\"--\",\"STARTYEAR\":\"--\",\"EMPLOYER\":\"张家口银行\",\"INDUSTRY_NAME\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"EMPLOYERTELEPHONENO\":\"--\",\"TITLE_NAME\":\"--\",\"UNITPROPERTIES_NAME\":\"--\",\"OCCUPATION_NAME\":\"专业技术人员\",\"GETTIME\":\"2020.01.09\",\"DUTY_NAME\":\"--\"},{\"EMPLOYERADDRESS\":\"--\",\"STARTYEAR\":\"--\",\"EMPLOYER\":\"北京思诺顺源管理咨询有限公司\",\"INDUSTRY_NAME\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"EMPLOYERTELEPHONENO\":\"--\",\"TITLE_NAME\":\"--\",\"UNITPROPERTIES_NAME\":\"--\",\"OCCUPATION_NAME\":\"--\",\"GETTIME\":\"2020.01.01\",\"DUTY_NAME\":\"--\"},{\"EMPLOYERADDRESS\":\"北京北京北京市东城区安定门外大街138号皇城国际B座\",\"STARTYEAR\":\"--\",\"EMPLOYER\":\"张家口银行股份有限公司\",\"INDUSTRY_NAME\":\"金融业\",\"REPORTNO\":\"2020022220531014465915\",\"EMPLOYERTELEPHONENO\":\"--\",\"TITLE_NAME\":\"无\",\"UNITPROPERTIES_NAME\":\"--\",\"OCCUPATION_NAME\":\"商业、服务业人员\",\"GETTIME\":\"2019.09.20\",\"DUTY_NAME\":\"一般员工\"},{\"EMPLOYERADDRESS\":\"--\",\"STARTYEAR\":\"--\",\"EMPLOYER\":\"张家口市商业银行广州分行\",\"INDUSTRY_NAME\":\"金融业\",\"REPORTNO\":\"2020022220531014465915\",\"EMPLOYERTELEPHONENO\":\"--\",\"TITLE_NAME\":\"--\",\"UNITPROPERTIES_NAME\":\"--\",\"OCCUPATION_NAME\":\"--\",\"GETTIME\":\"2014.08.26\",\"DUTY_NAME\":\"其他\"}],\"ICR_PIM_TELNUMBER\":[{\"REPORTNO\":\"2020022220531014465915\",\"PHONENUMBER\":\"1\",\"GETTIME\":\"2020.01.09\",\"MOBILE\":\"18655503214\"},{\"REPORTNO\":\"2020022220531014465915\",\"PHONENUMBER\":\"1\",\"GETTIME\":\"2020.01.09\",\"MOBILE\":\"18655503214\"},{\"REPORTNO\":\"2020022220531014465915\",\"PHONENUMBER\":\"1\",\"GETTIME\":\"2020.01.09\",\"MOBILE\":\"18655503216\"}],\"ICR_PDA_MONTHDISPLAY4\":[{\"ACCOUNTTYPE_NAME\":\"贷记卡账户\",\"OVERDUE61TO90AMOUNT\":0.0,\"REPORTNO\":\"2020022220531014465915\",\"OVERDUE31TO60AMOUNT\":0.0,\"ACTUALPAYMENTAMOUNT\":100.0,\"REMAINPAYMENTCYC\":204.0,\"OVERDUEOVER180AMOUNT\":0.0,\"BALANCE\":735061.0,\"CURROVERDUEAMOUNT\":0.0,\"OVERDUE91TO180AMOUNT\":0.0,\"CLASS5STATE_NAME\":\"正常\",\"SCHEDULEDPAYMENTAMOUNT\":500.0,\"ACCOUNTID\":\"1\",\"ACCOUNTSTATUS_NAME\":\"正常\",\"SCHEDULEDPAYMENTDATE\":\"2020.02.20\",\"RECENTPAYDATE\":\"2020.02.20\",\"CURROVERDUECYC\":1,\"LATEST6MONTHUSEDAVGAMOUNT\":80000},{\"ACCOUNTTYPE_NAME\":\"贷记卡账户\",\"OVERDUE61TO90AMOUNT\":0.0,\"REPORTNO\":\"2020022220531014465915\",\"OVERDUE31TO60AMOUNT\":0.0,\"ACTUALPAYMENTAMOUNT\":100.0,\"REMAINPAYMENTCYC\":204.0,\"OVERDUEOVER180AMOUNT\":0.0,\"BALANCE\":735061.0,\"CURROVERDUEAMOUNT\":0.0,\"OVERDUE91TO180AMOUNT\":0.0,\"CLASS5STATE_NAME\":\"正常\",\"SCHEDULEDPAYMENTAMOUNT\":500.0,\"ACCOUNTID\":\"2\",\"ACCOUNTSTATUS_NAME\":\"正常\",\"SCHEDULEDPAYMENTDATE\":\"2020.02.20\",\"RECENTPAYDATE\":\"2020.02.20\",\"CURROVERDUECYC\":1,\"LATEST6MONTHUSEDAVGAMOUNT\":80000},{\"ACCOUNTTYPE_NAME\":\"贷记卡账户\",\"OVERDUE61TO90AMOUNT\":0.0,\"REPORTNO\":\"2020022220531014465915\",\"OVERDUE31TO60AMOUNT\":0.0,\"ACTUALPAYMENTAMOUNT\":100.0,\"REMAINPAYMENTCYC\":204.0,\"OVERDUEOVER180AMOUNT\":0.0,\"BALANCE\":735061.0,\"CURROVERDUEAMOUNT\":0.0,\"OVERDUE91TO180AMOUNT\":0.0,\"CLASS5STATE_NAME\":\"正常\",\"SCHEDULEDPAYMENTAMOUNT\":100.0,\"ACCOUNTID\":\"3\",\"ACCOUNTSTATUS_NAME\":\"正常\",\"SCHEDULEDPAYMENTDATE\":\"2020.02.20\",\"RECENTPAYDATE\":\"2020.02.20\",\"CURROVERDUECYC\":1,\"LATEST6MONTHUSEDAVGAMOUNT\":80000}],\"ICR_PQO_LASTTIMEQUERYRECORD\":[{\"UPQUERYORG_NAME\":\"张家口银行股份有限公司\",\"REPORTNO\":\"2020022220531014465915\",\"UPQUERYDATE\":\"2020.02.20\",\"UPQUERYREASON_NAME\":\"信用卡审批\"}],\"ICR_PRH_DISSENTPROMPT\":[{\"REPORTNO\":\"2020022220531014465915\",\"DISSENTDESCRIBE\":\"信息主体对信用报告内容提出了0笔异议且正在处理中，请浏览时注意阅读相关内容。\"}],\"ICR_PMM_MARRIAGE\":[{\"SPOUSECERTNO\":\"--\",\"TELEPHONENO\":\"--\",\"MARITALSTATE_NAME\":\"已婚\",\"SPOUSENAME\":\"--\",\"EMPLOYER\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"SPOUSECERTTYPE_NAME\":\"--\"}],\"ICR_PQO_QUERYRECORD\":[{\"ORGSUM2\":1,\"RECORDSUM1\":0,\"ORGSUM1\":0,\"REPORTNO\":\"2020022220531014465915\",\"RECORDSUM3\":0,\"RECORDSUM2\":1,\"TOWYEARRECORDSUM3\":0,\"TOWYEARRECORDSUM2\":0,\"TOWYEARRECORDSUM1\":14}],\"ICR_PRM_RESIDE\":[{\"HOMETELEPHONENO\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"ADDRESS\":\"北京市丰台区西四环南路52号院内1号\",\"RESIDENCETYPE_NAME\":\"--\",\"GETTIME\":\"2020.01.09\"},{\"HOMETELEPHONENO\":\"1865503214\",\"REPORTNO\":\"2020022220531014465915\",\"ADDRESS\":\"西四环南路52号院内1号\",\"RESIDENCETYPE_NAME\":\"--\",\"GETTIME\":\"2019.09.30\"},{\"HOMETELEPHONENO\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"ADDRESS\":\"北京北京昌平区回龙观东大街紫金新干线2区3号楼2单元402\",\"RESIDENCETYPE_NAME\":\"--\",\"GETTIME\":\"2019.09.20\"},{\"HOMETELEPHONENO\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"ADDRESS\":\"北京北京北京昌平回龙观\",\"RESIDENCETYPE_NAME\":\"亲属楼宇\",\"GETTIME\":\"2018.11.15\"},{\"HOMETELEPHONENO\":\"--\",\"REPORTNO\":\"2020022220531014465915\",\"ADDRESS\":\"北京市朝阳区双营路11号美立方5号楼1单元1902\",\"RESIDENCETYPE_NAME\":\"租房\",\"GETTIME\":\"2016.03.14\"}],\"ICR_POQ_OTHERQUERY\":[{\"H_NUMBER\":\"1\",\"QUERYORG\":\"张家口银行股份有限公司\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"信用卡审批\",\"QUERYDATE\":\"2020.02.20\"},{\"H_NUMBER\":\"2\",\"QUERYORG\":\"商业银行\"OW\"\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"信用卡审批\",\"QUERYDATE\":\"2020.01.04\"},{\"H_NUMBER\":\"3\",\"QUERYORG\":\"张家口银行股份有限公司\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"信用卡审批\",\"QUERYDATE\":\"2019.09.30\"},{\"H_NUMBER\":\"4\",\"QUERYORG\":\"商业银行\"LE\"\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"信用卡审批\",\"QUERYDATE\":\"2019.09.27\"},{\"H_NUMBER\":\"5\",\"QUERYORG\":\"商业银:行\"TJ\"\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"信用卡审批\",\"QUERYDATE\":\"2019.09.20\"},{\"H_NUMBER\":\"6\",\"QUERYORG\":\"汽车金融公司1\"NR\"\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"贷款审批\",\"QUERYDATE\":\"2020.03.08\"},{\"H_NUMBER\":\"7\",\"QUERYORG\":\"汽车金融公司\"NR\"\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"贷款审批\",\"QUERYDATE\":\"2020.02.25\"},{\"H_NUMBER\":\"8\",\"QUERYORG\":\"汽车金融公司\"NR\"\",\"REPORTNO\":\"2020022220531014465915\",\"QUERYREASON_NAME\":\"贷款审批\",\"QUERYDATE\":\"2020.03.03\"}],\"ICR_PDA_BASEINFO2\":[{\"OPENDATE\":\"2017.02.14\",\"CURRENCY_NAME\":\"人民币元\",\"ACCOUNTTYPE_NAME\":\"贷记卡账户\",\"REPORTNO\":\"2020022220531014465915\",\"CREDITDEALNO\":\"\",\"PAYMENTCYC\":240.0,\"PUBLICLOANTYPE_NAME\":\"无\",\"PAYMENTRATING_NAME\":\"月\",\"ENDDATE\":\"2037.01.23\",\"PAYMENTTYPE_NAME\":\"--\",\"BORROWAMOUNT\":815000.0,\"GUARANTEETYPE_NAME\":\"保证\",\"ACCOUNTID\":\"1\",\"ACCOUNTIDENTITY\":\"JJ52171700000113\",\"BUSINESSTYPE_NAME\":\"贷记卡\",\"BUSINESSORG\":\"张家口银行股份有限公司\",\"ACCOUNTCREDITLIMIT\":100000},{\"OPENDATE\":\"2018.11.15\",\"CURRENCY_NAME\":\"人民币元\",\"ACCOUNTTYPE_NAME\":\"贷记卡账户\",\"REPORTNO\":\"2020022220531014465915\",\"CREDITDEALNO\":\"\",\"PAYMENTCYC\":24.0,\"PUBLICLOANTYPE_NAME\":\"无\",\"PAYMENTRATING_NAME\":\"月\",\"ENDDATE\":\"2020.11.15\",\"PAYMENTTYPE_NAME\":\"--\",\"BORROWAMOUNT\":1000.0,\"GUARANTEETYPE_NAME\":\"抵押\",\"ACCOUNTID\":\"2\",\"ACCOUNTIDENTITY\":\"******\",\"BUSINESSTYPE_NAME\":\"贷记卡\",\"BUSINESSORG\":\"汽车金融公司\"NR\"\",\"ACCOUNTCREDITLIMIT\":100000},{\"OPENDATE\":\"2018.11.15\",\"CURRENCY_NAME\":\"人民币元\",\"ACCOUNTTYPE_NAME\":\"贷记卡账户\",\"REPORTNO\":\"2020022220531014465915\",\"CREDITDEALNO\":\"\",\"PAYMENTCYC\":24.0,\"PUBLICLOANTYPE_NAME\":\"无\",\"PAYMENTRATING_NAME\":\"月\",\"ENDDATE\":\"2020.11.15\",\"PAYMENTTYPE_NAME\":\"--\",\"BORROWAMOUNT\":1000.0,\"GUARANTEETYPE_NAME\":\"抵押\",\"ACCOUNTID\":\"3\",\"ACCOUNTIDENTITY\":\"******\",\"BUSINESSTYPE_NAME\":\"贷记卡\",\"BUSINESSORG\":\"汽车金融公司\"NR\"\",\"ACCOUNTCREDITLIMIT\":100000}],\"ICR_PCO_CREDITCARD\":[{\"CREDITLIMIT\":204500.0,\"USEDCREDITLIMIT\":2870.0,\"ACCOUNTCOUNT\":5,\"FINANCEORGCOUNT\":5,\"REPORTNO\":\"2020022220531014465915\",\"MINCREDITLIMITPERORG\":500.0,\"MAXCREDITLIMITPERORG\":48000.0,\"LASTER6MONTHUSEDAVGAMOUNT\":4105.0}]}";
        Object o = JSON.toJSON(json);
        System.out.println(o);
        String s = toJsonString(o.toString());
        System.out.println(s);
        Map<String,List<Map<String,String>>> source = (Map<String, List<Map<String, String>>>) JSON.parse(s);
        System.out.println(source.get("ICR_POQ_OTHERQUERY"));

    }


    private static String toJsonString(String s) {
        char[] tempArr = s.toCharArray();
        int tempLength = tempArr.length;
        for (int i = 0; i < tempLength; i++) {
            if (tempArr[i] == ':' && tempArr[i + 1] == '"') {
                for (int j = i + 2; j < tempLength; j++) {
                    if (tempArr[j] == '"') {
                        if (tempArr[j + 1] != ',' && tempArr[j + 1] != '}') {
                            tempArr[j] = '”'; // 将value中的 双引号替换为中文双引号
                        } else if (tempArr[j + 1] == ',' || tempArr[j + 1] == '}') {
                            break;
                        }
                    }
                }
            }
        }
        return new String(tempArr);
    }

}
