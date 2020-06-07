package zookeeper;


public class ZkTest03 {
    public static void main(String[] args) throws Exception {


        ZkTest01.init();
        ZkTest01.watchChildren("/test/test02");
        ZkTest01.sleep();
    }
}
