package com.piashraful.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class DemoProjectForLearningApplication {

	public static void main(String[] args) {
		var contx = SpringApplication.run(DemoProjectForLearningApplication.class, args);
		MyFirstClass myFirstClass = contx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}
	
}
