package com.allstate_onboarding.jms_assignment.order_acknowledgement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@PropertySource("classpath:order_acknowledgement.properties")
public class OrderAcknowledgementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAcknowledgementApplication.class, args);
	}

}
