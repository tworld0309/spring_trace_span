package com.example.jsh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StarbucksService {
    private static final Logger logger = LoggerFactory.getLogger(StarbucksService.class);

    public void callService1() {
        logger.info("Starbucks Inside Service 1");
    }

    public void callService2() {
        logger.info("Starbucks Inside Service 2");
    }
}
