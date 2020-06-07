package zookeeper;

import org.apache.zookeeper.CreateMode;

public class ZkTest04 {
    public static void main(String[] args) throws Exception {
        ZkTest01.init();
        ZkTest01.client.create().withMode(CreateMode.PERSISTENT).forPath("/test/test02/ddd",null);
    }
}
