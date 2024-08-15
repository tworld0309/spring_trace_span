package com.example.jsh.controller;

import com.example.jsh.service.StarbucksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StarbucksController {

    private static final Logger logger = LoggerFactory.getLogger(StarbucksController.class);

    @Autowired
    private StarbucksService starbucksService;

    @RequestMapping("/jsh")
    @ResponseBody
    public String testEndpoint() {
        logger.info("Starbucks Controller /test request");

        starbucksService.callService1();
        starbucksService.callService2();
        return "Starbucks Check the logs for traceId and spanId";
    }

}