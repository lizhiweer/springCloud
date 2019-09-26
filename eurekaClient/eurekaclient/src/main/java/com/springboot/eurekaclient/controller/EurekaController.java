package com.springboot.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController{


    @GetMapping("/getClient")
    public String getClient(){
        return "i am eurekaclient";
    }


}