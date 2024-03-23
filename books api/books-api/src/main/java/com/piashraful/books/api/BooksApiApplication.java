package com.piashraful.books.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApiApplication {

	public static void main(String[] args) {
		System.out.println("started");
		SpringApplication.run(BooksApiApplication.class, args);
	}

}
