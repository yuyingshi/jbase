package com.cwww.redision;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author cWww
 * @Title
 * @Description 通过redisson获取redis中的数据
 * @date: 2018/5/31  12:54
 */
public class Demo2 {

    public static void main(String[] args) {

        final Config baseConfig = new Config();
        baseConfig.useSingleServer()
                .setConnectTimeout(30000)
                .setConnectionPoolSize(64)
                .setConnectionMinimumIdleSize(32)
                .setIdleConnectionTimeout(3000)
//                .setPassword("caiwei")
                .setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(baseConfig);
//        client.getLock("");
//        System.out.println(client);
//        System.out.println(client);
        RBucket<Long> hello = client.getBucket("hello");
        hello.set(100000L);
        System.out.println(hello.get());
        client.shutdown();
    }

}
