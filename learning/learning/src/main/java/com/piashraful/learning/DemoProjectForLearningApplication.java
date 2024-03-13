package com.piashraful.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DemoProjectForLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectForLearningApplication.class, args);
	}
	@GetMapping("/")
	public String sayHello(){
		return "Hello";
	}

	@PostMapping("/post-order")
	public String post(@RequestBody Order order){
		return "Order received  with customer name: "+order.getCustomerName() + "Order Id"+ order.getOrderId() +
				"order item Name: " + order.getOrderName();

	}
}
