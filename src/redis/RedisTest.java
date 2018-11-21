package redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisTest {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.auth("root");
        System.out.println("连接redis成功");
        //查看服务是否运行
        System.out.println("redis服务正在运行：" + jedis.ping());
        RedisTest redisTest = new RedisTest();
        //存储数据
//        redisTest.setData(jedis);
        //获取数据
        redisTest.getData(jedis);
    }

    private void setData(Jedis jedis) {
        // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
        jedis.set("name", "jaty");

        //存储数据到列表中
        jedis.lpush("dbName", "Redis");
        jedis.lpush("dbName", "Mongodb");
        jedis.lpush("dbName", "Mysql");

    }

    private void getData(Jedis jedis) {
        String name = jedis.get("name");
        System.out.println("姓名：" + name);

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("dbName", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("数据库的名称: " + list.get(i));
        }
    }


}
