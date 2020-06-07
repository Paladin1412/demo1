package zookeeper;

//import com.google.common.util.concurrent.ListeningExecutorService;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.proto.WatcherEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ZkTest01 {
    public static CuratorFramework client;

    public static void main(String[] args) throws Exception {

        init(); //初始化client
//        deleteGuaranteed("/test");
//        createGuaranteed("/test/test03");
//        createEphemeral("/test/test04");
//        for (int i = 0; i < 5; i++) {
//            createSeria("/test/test01/aaa");
//            Thread.sleep(1000);
//        }
        addListen("/test/test01");

        List<String> children = getChildren("/test/test01");
        children.forEach(child -> {
            try {
                addListen("/test/test01/" + child);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        sleep();
    }

    public static void addListen(String path) throws Exception {
        client.getData()
                .usingWatcher((Watcher) watchedEvent -> {
                    System.out.println(watchedEvent.getPath());
                    Watcher.Event.KeeperState state = watchedEvent.getState();

//                    System.out.println(state.getIntValue());
                    Watcher.Event.EventType type = watchedEvent.getType();
//                    int intValue = type.getIntValue();
//                    System.out.println(intValue);

                    switch (type) {
                        case None:
                            System.out.println("case None");
                            break;
                        case NodeCreated:
                            System.out.println("case NodeCreated");
                            break;
                        case NodeDeleted:
                            System.out.println("case NodeDeleted");
                            break;
                        case NodeDataChanged:
                            System.out.println("case NodeDataChanged");
                            break;
                        case NodeChildrenChanged:
                            System.out.println("case NodeChildrenChanged");
                            break;
                        default:
                            System.out.println("default " + watchedEvent.getType());
                            break;
                    }


                    WatcherEvent wrapper = watchedEvent.getWrapper();
                    String path1 = wrapper.getPath();
                    System.out.println(path1);

                    System.out.println("------------------------------------");

                    try {
                        addListen(path);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                .forPath(path);
    }

    public static List<String> getChildren(String s) throws Exception {
        List<String> list = client.getChildren().forPath(s);

        list.forEach(str -> {
            try {
                byte[] bytes = client.getData().forPath(s + "/" + str);
                System.out.println(s + "/" + str + "  " + new String(bytes));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return list;
    }

    public static String getVal(String path) throws Exception {
        byte[] bytes = client.getData().forPath(path);
        return new String(bytes);
    }

    public static void createSeria(String path) throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        client.create()
                .withMode(CreateMode.PERSISTENT_SEQUENTIAL)
                .forPath(path, sdf.format(date).getBytes());
    }

    public static void sleep() {
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void createEphemeral(String path) {
        try {
            client.create()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createGuaranteed(String path) throws Exception {
        createGuaranteed(path, null);
    }

    public static void createGuaranteed(String path, byte[] val) {
        try {
            client.create()
                    .creatingParentsIfNeeded()
                    .forPath(path, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //强制删除节点
    public static void deleteGuaranteed(String path) {
        try {
            client.delete()
                    .guaranteed()   //保证强制删除
                    .deletingChildrenIfNeeded() //递归删除
                    .forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient("192.168.75.128:2181", 5000, 5000, retryPolicy);
        client.start();
    }

    public static String createEphemeralSerial(String path, String val) throws Exception {
        return client.create()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath(path, val.getBytes());
    }

    public static void zkWatch(String path) {

        client.getCuratorListenable()
                .addListener((curatorFramework, curatorEvent) -> {
                    List<String> children = curatorEvent.getChildren();
                    System.out.println("1. " + children);
                    byte[] data = curatorEvent.getData();
                    System.out.println("2. " + new String(data));
                    String name = curatorEvent.getName();
                    System.out.println("3. " + name);
                    String path1 = curatorEvent.getPath();
                    System.out.println("4. " + path1);
                    Stat stat = curatorEvent.getStat();
                    System.out.println("5. " + stat);
                    CuratorEventType type = curatorEvent.getType();
                    System.out.println("6. " + type);
                    WatchedEvent watchedEvent = curatorEvent.getWatchedEvent();
                    System.out.println("7. " + watchedEvent);
                });
    }

    public static void watchChildren(String path) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(client, path, true);
        cache.start();
        cache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
            PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
            ChildData data = pathChildrenCacheEvent.getData();
            byte[] data1 = data.getData();
            String path1 = data.getPath();
            Stat stat = data.getStat();
            switch (type) {
                case CHILD_ADDED:
                    System.out.println(Thread.currentThread().getName() + " - add child - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                case CHILD_REMOVED:
                    System.out.println(Thread.currentThread().getName() + " - removed child - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                case CHILD_UPDATED:
                    System.out.println(Thread.currentThread().getName() + " - update child - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                case CONNECTION_LOST:
                    System.out.println(Thread.currentThread().getName() + " - lost - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                case CONNECTION_SUSPENDED:
                    System.out.println(Thread.currentThread().getName() + " - suspended - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                case CONNECTION_RECONNECTED:
                    System.out.println(Thread.currentThread().getName() + " - reconnected - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                case INITIALIZED:
                    System.out.println(Thread.currentThread().getName() + " - initialized - " + path1 + " - " + new String(data1) + " - " + stat);
                    break;
                default:
                    break;
            }

        });

    }

}
