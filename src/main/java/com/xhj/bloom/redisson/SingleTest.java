package com.xhj.bloom.redisson;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author jack xu
 */
public class SingleTest {
    public static void main(String[] args) {

        Config config = new Config();
        config.setCodec(new org.redisson.client.codec.StringCodec());

        //指定使用单节点部署方式
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);

        RBloomFilter<SomeObject> bloomFilter = redisson.getBloomFilter("sample");
        // 初始化布隆过滤器，预计统计元素数量为55000000，期望误差率为0.03
        bloomFilter.tryInit(55000000L, 0.03);
        bloomFilter.add(new SomeObject("field1Value", "field2Value"));
        bloomFilter.add(new SomeObject("field5Value", "field8Value"));
        bloomFilter.contains(new SomeObject("field1Value", "field8Value"));
    }

}