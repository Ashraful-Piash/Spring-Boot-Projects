package com.piashraful.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoProjectForLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectForLearningApplication.class, args);
	}
	@GetMapping("/")
	public String hello(){
		return "hello piash";
	}


}
