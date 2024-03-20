package com.jsss.qianfan;

import com.jsss.qianfan.util.QianfanUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class QianfanApplicationTests {



    @Autowired
    QianfanUtil qianfanUtil;

    @Test
    void contextLoads() {
        String content="你好";
        String res = qianfanUtil.addMessage(content);
        System.out.println(res);

    }

    @Test
    void test() {
        String content="你好";
        qianfanUtil.executeStream(content);

    }



}
