package com.eussi.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxueming
 * @create 2020-02-23 18:32
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    private CounterService counterService;

    @RequestMapping("/hello")
    public String index() {
        counterService.increment("counter.wangxm.count");
        return "Hello World";
    }
}
