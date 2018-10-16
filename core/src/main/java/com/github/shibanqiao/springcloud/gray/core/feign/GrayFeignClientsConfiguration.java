package com.github.shibanqiao.springcloud.gray.core.feign;

import com.github.shibanqiao.springcloud.gray.core.feign.ribbon.GrayFeignClient;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrayFeignClientsConfiguration {

    @Autowired
    private Client feignClient;

    @Bean
    public Client client() {
        return new GrayFeignClient(feignClient);
    }

}