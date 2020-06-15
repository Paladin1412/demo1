package fengkongyingqing.groovy

import com.alibaba.fastjson.JSON

import java.text.SimpleDateFormat

/**
 * @FileName: Test2.java* @Description: Test2.java类说明* @Author: wei.tang* @Date: 2020/6/12 11:05
 */
class Test2 {

    static void main(String[] args) {
//        String source = Test1.source();
//        int result = execute(source)
//        println result
        println aaa()

    }

    static int execute(String source) {
        println source
        int result = 0
        try {
            source = JSON.toJSON(source)
            char[] tempArr = source.toCharArray()
            int tempLength = tempArr.length
            for (int i = 0; i < tempLength; i++) {
                if (tempArr[i] == ':' && tempArr[i + 1] == '"') {
                    for (int j = i + 2; j < tempLength; j++) {
                        if (tempArr[j] == '"') {
                            if (tempArr[j + 1] != ',' && tempArr[j + 1] != '}') {
                                tempArr[j] = '”'
                            } else if (tempArr[j + 1] == ',' || tempArr[j + 1] == '}') {
                                break;
                            }
                        }
                    }
                }
            }
            source = new String(tempArr)

            Date dNow = new Date();
            Date dBefore = new Date();
            Calendar calendar = Calendar.getInstance()
            calendar.setTime(dNow)
            calendar.add(Calendar.MONTH, -8)
            dBefore = calendar.getTime()
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd")
            String defaultStartDate = sdf.format(dBefore)   //8个月前
            String defaultEndDate = sdf.format(dNow)  //当前时间

            Map<String, Set<String>> container = new HashMap<>()

            Map<String, List<Map<String, String>>> map = JSON.parse(source)
            List<Map<String, String>> sourceList = map["ICR_POQ_OTHERQUERY"]
            sourceList.each {
                String date = it["QUERYDATE"]
                String name = it["QUERYREASON_NAME"]
                String org = it["QUERYORG"]
                Date date1 = sdf.parse(date);
                if (date1 <= sdf.parse(defaultEndDate) && date1 >= sdf.parse(defaultStartDate)) {
                    if ("贷款审批".equals(name) || "信用卡审批".equals(name)) {
                        Set<String> names = container.get(org)
                        if (names == null) {
                            names = new HashSet<>()
                        }
                        names.add(name)
                        container.put(org, names)
                    }
                }
            }
            container.each {
                k, v ->
                    {
                        result += v.size()
                    }
            }
        } catch (Exception e) {
            println e

        }
        return result
    }


    static int aaa() {
        String source = Test1.source()
        int result = 0
        try {
            source = JSON.toJSON(source)
            char[] tempArr = source.toCharArray()
            int tempLength = tempArr.length
            for (int i = 0; i < tempLength; i++) {
                if (tempArr[i] == ':' && tempArr[i + 1] == '"') {
                    for (int j = i + 2; j < tempLength; j++) {
                        if (tempArr[j] == '"') {
                            if (tempArr[j + 1] != ',' && tempArr[j + 1] != '}') {
                                tempArr[j] = '”'
                            } else if (tempArr[j + 1] == ',' || tempArr[j + 1] == '}') {
                                break;
                            }
                        }
                    }
                }
            }
            source = new String(tempArr)

            Date dNow = new Date();
            Date dBefore = new Date();
            Calendar calendar = Calendar.getInstance()
            calendar.setTime(dNow)
            calendar.add(Calendar.MONTH, -8)
            dBefore = calendar.getTime()
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd")
            String defaultStartDate = sdf.format(dBefore)   //8个月前
            String defaultEndDate = sdf.format(dNow)  //当前时间

            Map<String, Set<String>> container = new HashMap<>()

            Map<String, List<Map<String, String>>> map = JSON.parse(source)
            List<Map<String, String>> sourceList = map["ICR_POQ_OTHERQUERY"]
            sourceList.each {
                String date = it["QUERYDATE"]
                String name = it["QUERYREASON_NAME"]
                String org = it["QUERYORG"]
                Date date1 = sdf.parse(date);
                if (date1 <= sdf.parse(defaultEndDate) && date1 >= sdf.parse(defaultStartDate)) {
                    if ("贷款审批".equals(name) || "信用卡审批".equals(name)) {
                        Set<String> names = container.get(org)
                        if (names == null) {
                            names = new HashSet<>()
                        }
                        names.add(name)
                        container.put(org, names)
                    }
                }
            }
            container.each {
                k, v ->
                    {
                        result += v.size()
                    }
            }
        } catch (Exception e) {
            println e
            result = 0
        }
        return result
    }

}
