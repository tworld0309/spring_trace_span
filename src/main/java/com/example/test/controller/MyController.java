package com.example.test.controller;

import com.example.test.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @RequestMapping("/test")
    @ResponseBody
    public String testEndpoint() {
        logger.info("Controller /test request");

        myService.callService1();
        myService.callService2();
        return "Check the logs for traceId and spanId";
    }

}