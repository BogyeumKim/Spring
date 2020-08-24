package com.aia.mm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberRestApiApplication {

	public static void main(String[] args) {
		System.out.println("Start Spring");
		SpringApplication.run(MemberRestApiApplication.class, args);
	}
	
	
	

}
