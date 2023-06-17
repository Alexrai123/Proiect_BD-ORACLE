package com.proiect.bazededate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BazededateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazededateApplication.class, args);
	}

}
