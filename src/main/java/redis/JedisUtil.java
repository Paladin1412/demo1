package redis;

import redis.clients.jedis.Jedis;

public class JedisUtil {
    private static String host = "192.168.75.128";
    private static int port = 7001;
    public static Jedis jedis;

    static{
        jedis = new Jedis(host,port);
    }
//    public static Jedis init(){
//        return new Jedis(host,port);
//    }

    private static void keys(){
        jedis.keys("*");
    }

    public static void main(String[] args) {
        String key = "";
        String valString = "";
        //String类型
        jedis.flushDB();//删除当前库
        jedis.flushAll();//删除所有库
        jedis.del(key); //删除当前key
        jedis.setnx(key,valString); //如果key存在，则进行存储

        //hash类型

    }

}
