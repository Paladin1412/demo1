package redis;

import com.alibaba.fastjson.JSON;
import com.netty08.Person;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest01 {
    static Jedis jedis;
    static {
        jedis = new Jedis("192.168.75.128",7001);
    }
    public static void main(String[] args) {
        jedis.flushAll();//删除所有库
        String key = "keyHash";
//        Person person = new Person();
//        person.setName("张三");
//        person.setAge(12);
//        person.setAddress("湖北钟祥");
//        jedis.hset(key,"name",person.getName());
//        jedis.hset(key,"age","12");
//        jedis.hset(key,"address",person.getAddress());
//        String name = jedis.hget(key, "name");
//        System.out.println(name);
        Map<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","15");
        map.put("address","钟祥");

        String hmset = jedis.hmset(key+"1", map);
        System.out.println(hmset);
        List<String> hmget = jedis.hmget(key + "1", "name", "age", "address");
        System.out.println(hmget);
        Boolean name = jedis.hexists(key + "1", "name");
        System.out.println(name);
        Long hlen = jedis.hlen(key + "1");
        System.out.println(hlen);
        Long name1 = jedis.hdel(key + "1", "name");
        System.out.println(name1);
        System.out.println(jedis.hkeys(key+"1"));
        System.out.println(jedis.hvals(key+"1"));
        System.out.println(jedis.hgetAll(key+"1"));


        Set<String> sunion = jedis.sunion("", "");



//        sleep(Integer.MAX_VALUE);
    }
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> delKeys(String s){
        Set<String> keys = jedis.keys(s);
//        System.out.println(keys);
        keys.forEach(key->{
            jedis.del(key); //删除当前key
        });
        return keys;
    }


}
