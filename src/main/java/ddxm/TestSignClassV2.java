package ddxm;



import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目2根据代码模板完善功能
 * 返回正确请求内容
 * {"msg":"处理成功","result":"请求成功：[b9b88e31-45a3-4f65-b8e2-a303f1399e04]","code":200}
 */
public class TestSignClassV2 {

    public static String SECRET = "98455d163488a2";
    public static String APP_ID = "d62a540978cf";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String requestUrl = "http://test.xiongmaodangao.com/testcase/v2";
        HttpRequest httpRequest = HttpUtil.createPost(requestUrl);
        /**start 加入请求参数**/
        Map<String, Object> map = new HashMap<>();
//        httpRequest.header()
        /**end 加入请求参数**/

        /**start 签名**/
        String sign = sign(/*...*/);
        System.out.println("签名：" + sign);
        map.put("sig", sign);

        /**end 签名**/
//        httpRequest.basicAuth("")

        //加入请求参数
        httpRequest.body(JSON.toJSONString(map));
        HttpRequest form1 = httpRequest.form(map);
        Map<String, Object> form = httpRequest.form(/*..*/);
        System.out.println("form");
        System.out.println(form1);

        //发送请求
        HttpResponse response = httpRequest.execute();
        //打印结果
        System.out.println(response.body());
    }

    //补充方法
    private static String sign(/*...*/) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        /**start 补充签名**/

        /**end 补充签名**/
        System.out.println("待签名：" + stringBuilder.toString());
        return stringToMD5(stringBuilder.toString()).toLowerCase();
    }

    //MD5
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
