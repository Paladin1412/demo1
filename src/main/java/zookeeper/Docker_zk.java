package zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Date;
import java.util.List;

public class Docker_zk {
    static String ip1 = "192.168.75.128";
//    192.168.75.128
    static String ip2 = "172.17.0.2";
    public static void main(String[] args) throws Exception {


        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(ip1, 5000, 5000, retryPolicy);
        client.start();
        List<String> list = client.getChildren().forPath("/dubbo");
//        list.forEach(s -> {
//            try {
//                System.out.println(client.getData().forPath("/dubbo/com.dingxianginc.authority.sdk.api.dubbo.ILicenseCheckService/"+s));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        System.out.println(list);
//        byte[] bytes = client.getData().forPath("/test");
//        System.out.println(new String(bytes));


    }
}
