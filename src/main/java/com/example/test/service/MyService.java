package com.example.test.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MyService {
    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void callService1() {
        logger.info("Inside Service 1");
    }

    public void callService2() {
        logger.info("Inside Service 2");
    }
}
