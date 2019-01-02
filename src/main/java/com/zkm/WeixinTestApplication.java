package com.zkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeixinTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinTestApplication.class, args);
	}
}
