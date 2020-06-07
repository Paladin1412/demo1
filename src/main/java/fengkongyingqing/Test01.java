/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package fengkongyingqing;

import com.alibaba.fastjson.JSON;
import com.dingxianginc.ctucommon.client.CtuClient;
import com.dingxianginc.ctucommon.client.model.CtuRequest;
import com.dingxianginc.ctucommon.client.model.CtuResponse;

import java.util.*;

/**
 * @FileName: Test01.java
 * @Description: Test01.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/27 11:16
 */
public class Test01 {

    /**
     * 风控引擎url
     **/
    public static final String URL = "http://10.1.2.48:7776/ctu/event.do";
//    public static final String URL = "http://127.0.0.1:7090/ctu/event.do";
    /**
     * 应用appKey，公钥
     **/
    public static final String APP_KEY = "605dcafeb376c367b4d3fd4b91ec6a84";
    /**
     * 应用appSecret，私钥
     **/
    public static final String APP_SECRET = "66fce3ad3c2acc4daa2f9b0e3c0d6b95";
    public static final String EVENT_CODE = "shijian1";

    public static void main(String[] param) throws Exception {
        /**业务请求数据**/
        Map<String, Object> data = new HashMap<>();
        data.put("ceshiint1", 2);
//        data.put("ceshiint2", 11);
//        data.put("ceshiriqi","2020-01-01 12:12:12");
//        data.put("ceshiziduan","赵六");
//        data.put("ceshiziduan2","李四");
//        data.put("ID1003480","1");

        CtuRequest request = new CtuRequest();
        request.setEventCode(EVENT_CODE);
        request.setData(data);
        request.setFlag("activity_" + System.currentTimeMillis());
        CtuClient client = new CtuClient(URL, APP_KEY, APP_SECRET, 60000, 60000, 240000);

        CtuResponse response = client.checkRisk(request);
        System.out.println(JSON.toJSONString(response));

    }

}
