/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package fengkongyingqing;

import com.alibaba.fastjson.JSON;
import com.dingxianginc.ctucommon.client.CtuClient;
import com.dingxianginc.ctucommon.client.model.CtuRequest;
import com.dingxianginc.ctucommon.client.model.CtuResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName: Test01.java
 * @Description: Test01.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/27 11:16
 */
public class PhoneSource {
    /**
     * 风控引擎url
     **/
    public static final String URL = "http://10.2.1.106:7776/ctu/event.do";
//    public static final String URL = "http://127.0.0.1:7090/ctu/event.do";
    /**
     * 应用appKey，公钥
     **/
    public static final String APP_KEY = "e63b1a729dc3dd82ee9605ef52fc46cb";
    /**
     * 应用appSecret，私钥
     **/
    public static final String APP_SECRET = "ccf6f1f733bfc353dba6f14e01899cba";
    public static final String EVENT_CODE = "shijian2";

    public static void main(String[] param) throws Exception {
        /**业务请求数据**/
        Map<String, Object> data = new HashMap<>();
        data.put("phone2", "13712341234");
//        data.put("name333", "tom");
//        data.put("age333", 10);
//        data.put("AppId","e63b1a729dc3dd82ee9605ef52fc46cb");
//        data.put("AppSecret","ccf6f1f733bfc353dba6f14e01899cba");
        CtuRequest request = new CtuRequest();
        request.setEventCode(EVENT_CODE);
        request.setData(data);
        request.setFlag("activity_" + System.currentTimeMillis());
        CtuClient client = new CtuClient(URL, APP_KEY, APP_SECRET, 60000, 60000, 240000);

        CtuResponse response = client.checkRisk(request);
        System.out.println(JSON.toJSONString(response));

    }

}
