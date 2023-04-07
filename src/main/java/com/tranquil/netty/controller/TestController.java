package com.tranquil.netty.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tranquil_chen
 * @Time: 2023/4/7  17:38
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("test")
    public String test(){
        return "hello word!";
    }
}
