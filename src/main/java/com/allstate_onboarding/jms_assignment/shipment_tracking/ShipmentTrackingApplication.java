package com.allstate_onboarding.jms_assignment.shipment_tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@PropertySource("classpath:shipment_tracking.properties")
@ComponentScan(basePackages = "com.allstate_onboarding.jms_assignment")
public class ShipmentTrackingApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ShipmentTrackingApplication.class, args);
        new SpringApplicationBuilder(ShipmentTrackingApplication.class)
                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
                .run(args);
    }
}
