package redis;

import redis.clients.jedis.Jedis;

public class JedisStringUtil {
    private static Jedis jedis = JedisUtil.jedis;

    public static void set(String key,String val){
        jedis.set(key,val);
    }


    public static void main(String[] args) {
        String key = "";
        String val = "";
        jedis.set(key,val);
        jedis.get(key);
        jedis.setnx(key,val);


    }



}
