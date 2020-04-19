package com.xhj.bloom.countBloom;

import orestes.bloomfilter.CountingBloomFilter;
import orestes.bloomfilter.FilterBuilder;

/**
 * https://github.com/Baqend/Orestes-Bloomfilter
 * 带计数器的布隆过滤器
 */
public class CountingBloomFilterTest {
    public static void main(String[] args) {
        CountingBloomFilter<String> cbf = new FilterBuilder(1000,
                0.01).buildCountingBloomFilter();
        cbf.add("http://gupaoedu.com");
        cbf.add("http://alibaba.com");
        cbf.add("http://baidu.com");

        cbf.remove("http://baidu.com");

        System.out.println(cbf.contains("http://gupaoedu.com")); //true
        System.out.println(cbf.contains("http://alibaba.com")); //true
        System.out.println(cbf.contains("http://baidu.com")); //false
    }
}
