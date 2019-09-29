package com.example.sleuth;

import com.example.sleuth.feign.TestRemote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@SpringBootApplication
public class DemoApplication {

	@Autowired
	TestRemote remote;

	@GetMapping("/zipkin")
	public String zipkin(){

		return remote.getClient();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
