package com.springboot.eurekaclient1.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eurekaclient",fallback = FeignHystrix.class)     //调用服务的 spring.application.name
public interface FeignRemote{

    //调用服务的RestFul接口
    @RequestMapping("/getClient")   
    public String hello();
    
    
}