package zookeeper;

public class ZkTest02 {
    public static void main(String[] args) throws Exception {
        ZkTest01 zkTest01 = new ZkTest01();

        ZkTest01.init();
        ZkTest01.createEphemeralSerial("/test/test02/aaa","100");
        ZkTest01.sleep();
    }
}
