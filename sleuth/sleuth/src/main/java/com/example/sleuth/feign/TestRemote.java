package com.example.sleuth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="eurekaclient1")
public interface TestRemote{


    @GetMapping("/getClientRemote")
    public String getClient();

}