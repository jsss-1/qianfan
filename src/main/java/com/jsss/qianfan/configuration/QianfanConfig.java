package com.jsss.qianfan.configuration;


import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.core.auth.Auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QianfanConfig {

    @Value("${QIANFAN_ACCESS_KEY}")
    String ak;

    @Value("${QIANFAN_SECRET_KEY}")
    String sk;

    @Bean
    public Qianfan qianFan() {
        return new Qianfan(Auth.TYPE_OAUTH, ak, sk);
    }
}
