package com.github.shibanqiao.springcloud.practice.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String test(@RequestHeader("x-label") String label) {
        logger.info("label: " + label);
        String result = restTemplate.getForObject("http://provider/user", String.class);
        return result;
    }
}
