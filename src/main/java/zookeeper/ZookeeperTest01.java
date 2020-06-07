//package zookeeper;
//
//import com.google.gson.internal.bind.util.ISO8601Utils;
//import org.apache.zookeeper.KeeperException;
//import org.apache.zookeeper.ZooKeeper;
////import org.junit.After;
////import org.junit.Before;
////import org.junit.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class ZookeeperTest01 {
//
//    ZooKeeper zooKeeper ;
////    @Before
//    public void init(){
//        try {
//            zooKeeper = new ZooKeeper("192.168.75.128:2181", 2000, null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
////    @Test
//    public void test01()  {
//        List<String> children = null;
//        try {
//            children = zooKeeper.getChildren("/", null);
//        } catch (KeeperException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(children);
//
//    }
//
////    @After
//    public void after(){
//        try {
//            Thread.sleep(Integer.MAX_VALUE);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
