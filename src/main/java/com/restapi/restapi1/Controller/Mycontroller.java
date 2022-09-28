package com.restapi.restapi1.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    private  final Logger LOGGER = LoggerFactory.getLogger(Mycontroller.class);
    @GetMapping("/")
    public String homePage(){
        LOGGER.trace("Tracing message");
        LOGGER.debug("Debug message");
        LOGGER.info("Info message");
        LOGGER.error("Error Message");

        return "Welcome to my first restapi web Panchanan";
    }

}
