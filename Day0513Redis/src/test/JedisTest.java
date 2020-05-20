package test;

import Utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name","zhangsan123");
        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name","zhangsan123");
        String name = jedis.get("name");
        System.out.println(name);

//        setex() 方法，指定过期时间的key,value
        jedis.setex("code",20,"hehe");//只存活20秒，20秒后自动删除
        jedis.close();
    }

    /**
     * hash数据结构操作
     */
    @Test
    public void test3(){
        Jedis jedis = new Jedis("localhost", 6379);
//        存储hash
        jedis.hset("user","name","zhangsan123");
        jedis.hset("user","age","13");
        jedis.hset("user","gender","male");
//        获取hash
        String name = jedis.hget("user","gender");
//        System.out.println(name);
//        获取hash中所有map数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keys = user.keySet();
        for (String key : keys) {
            String value = user.get(key);
            System.out.println(key+":"+value);
        }
        jedis.close();
    }

    /**
     * list数据结构操作
     */
    @Test
    public void test4(){
        Jedis jedis = new Jedis("localhost", 6379);
//        存储list
//        从左边存
        jedis.lpush("mylist","a","b","c");
//        从右边存
        jedis.rpush("mylist","a","b","c");
//        获取所有
        List<String> list = jedis.lrange("mylist", 0, -1);
        System.out.println(list);
        System.out.println(jedis.lpop("mylist"));
        System.out.println(jedis.rpop("mylist"));

        jedis.close();
    }


    /**
     * set数据结构操作
     */
    @Test
    public void test5(){
        Jedis jedis = new Jedis("localhost", 6379);
//        存储set
        jedis.sadd("myset","java","php","c++");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.close();
    }


    /**
     * sortedset数据结构操作
     */
    @Test
    public void test6(){
        Jedis jedis = new Jedis("localhost", 6379);
//        存储sortedset
        jedis.zadd("mysortedset",3,"yase");
        jedis.zadd("mysortedset",30,"houyi");
        jedis.zadd("mysortedset",25,"sunwukong");
//        获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
        jedis.close();
    }

    /**
     * 连接池操作
     */
    @Test
    public void test7(){
//        创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
//        配置参数
        config.setMaxTotal(50);
        config.setMaxIdle(10);
//        获取连接池
        JedisPool pool = new JedisPool(config,"localhost",6379);
//        获取Jedis对象
        Jedis jedis = pool.getResource();
        jedis.set("pool","default");
        jedis.close();
    }



    /**
     * 连接池工具类操作
     */
    @Test
    public void test8(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("pool2","default");
        jedis.close();
    }

}
