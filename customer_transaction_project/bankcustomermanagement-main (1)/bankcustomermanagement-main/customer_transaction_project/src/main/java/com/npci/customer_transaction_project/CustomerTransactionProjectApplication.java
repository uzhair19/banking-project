package com.npci.customer_transaction_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CustomerTransactionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerTransactionProjectApplication.class, args);
	}

}
