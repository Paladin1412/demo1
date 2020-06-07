package redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Docker_redis {
    public static void main(String[] args) {
        String pwd = "dingXiang123";
        Jedis jedis = new Jedis("192.168.75.128",7001);
        jedis.auth(pwd);
//        Jedis jedis1 = new Jedis();
//        Set<String> keys = jedis.keys("*");
//        System.out.println(keys);
        System.out.println(jedis.get("aa"));
        jedis.set("test","hello");
//        Set<String> keys1 = jedis.keys("*");
//        keys1.forEach(key->{
//            System.out.println(key+":"+jedis.get(key));
//        });
        String test = jedis.get("test");
        System.out.println(test);


    }
}
