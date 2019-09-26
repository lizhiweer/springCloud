package com.springboot.eurekaclient1.controller;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrix implements FeignRemote{

    @Override
    public String hello() {
        return "服务调用失败";
    }

    
}