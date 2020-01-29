package com.xhj.redisdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisDemoApplicationTests {

/*    @Autowired
    RedisUtil util;*/

    @Test
    void contextLoads() {
/*        util.set("boot", "2673--" + System.currentTimeMillis());
        System.out.println(util.get("boot"));*/
    }

}