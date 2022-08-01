package com.ecomerce.onlinefoodordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class OnlineFoodOrderingApplication {

	public static void main(String[] args) {

		SpringApplication.run(OnlineFoodOrderingApplication.class, args);

		Timestamp time = new Timestamp(System.currentTimeMillis());
		System.out.println(time);

	}

}
