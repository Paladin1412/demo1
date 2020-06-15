/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package fengkongyingqing;

import com.alibaba.fastjson.JSON;
import com.dingxianginc.ctucommon.client.CtuClient;
import com.dingxianginc.ctucommon.client.model.CtuRequest;
import com.dingxianginc.ctucommon.client.model.CtuResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: Test01.java
 * @Description: Test01.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/27 11:16
 */
public class Test_guanhui {

    /**
     * 风控引擎url
     **/
    public static final String URL = "http://10.1.2.48:7776/ctu/event.do";
    /**
     * 应用appKey，公钥
     **/
    public static final String APP_KEY = "6c3b75b0ee71a3b26b87a499f75063c0";
//    public static final String APP_KEY = "bd4837cf331f1fe9ece2dc18e2dced0f";
    /**
     * 应用appSecret，私钥
     **/
    public static final String APP_SECRET = "ea633242cdccfce2848cff45b516ecb0";
//    public static final String APP_SECRET = "38d86f36d7508107d4da0b7b379fd044";
//    public static final String EVENT_CODE = "ceshi";
    public static final String EVENT_CODE = "test_kevi_event";

    public static void main(String[] param) throws Exception {
        for (int i = 0; i < 1; i++) {

            /**业务请求数据**/
            Map<String, Object> data = new HashMap<>();
            data.put("testCount", 1);
//            data.put("test_bool",true);
            data.put("user_name","112");
//            data.put("test_money",12);



            CtuRequest request = new CtuRequest();
            request.setEventCode(EVENT_CODE);
            request.setData(data);
            request.setFlag("activity_" + System.currentTimeMillis());
            CtuClient client = new CtuClient(URL, APP_KEY, APP_SECRET, 60000, 60000, 240000);

            CtuResponse response = client.checkRisk(request);
            System.out.println(JSON.toJSONString(response));

        }
    }

}
