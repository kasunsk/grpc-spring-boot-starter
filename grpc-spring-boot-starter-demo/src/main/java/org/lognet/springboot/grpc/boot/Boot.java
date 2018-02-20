package org.lognet.springboot.grpc.boot;

import org.lognet.springboot.grpc.demo.CalculateService;
import org.lognet.springboot.grpc.demo.GreeterService;
import org.lognet.springboot.grpc.demo.InvoiceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boot {

    @Bean
    public GreeterService getGreetingService() {
        System.out.println("greeting service created");
        return new GreeterService();
    }

    @Bean
    public CalculateService getCalculateService() {
        System.out.println("Calculate Service created");
        return new CalculateService();
    }

    @Bean
    public InvoiceService getInvoiceService() {
        System.out.println("Invoice Service created");
        return new InvoiceService();
    }


    public static void main(String args []){
        System.out.println("Server is starting");
        SpringApplication.run(Boot.class,args);
        System.out.println("Server started ...");
    }
}
