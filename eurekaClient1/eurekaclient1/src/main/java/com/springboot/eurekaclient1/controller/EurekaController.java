package com.springboot.eurekaclient1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController{

    @Autowired
    private FeignRemote remote;

    @GetMapping("/getClient")
    public String getClient(){

        return "i am eureka client 1号";
    }

    @GetMapping("/getClientRemote")
    public String getClientRemote(){

        return remote.hello();
    }

}