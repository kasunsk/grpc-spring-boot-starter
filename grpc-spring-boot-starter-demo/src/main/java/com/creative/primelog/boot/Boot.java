package com.creative.primelog.boot;

import com.creative.primelog.adaptor.InvoiceAdaptor;
import com.creative.primelog.dao.InvoiceDao;
import com.creative.primelog.dao.InvoiceDaoImpl;
import com.creative.primelog.service.InvoiceService;
import org.lognet.springboot.grpc.demo.GreeterService;
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
    public InvoiceService getInvoiceService() {
        System.out.println("Invoice service created");
        return new InvoiceService();
    }

    @Bean
    public InvoiceDao getInvoiceDao(){
        System.out.println("Dao created");
        return new InvoiceDaoImpl();
    }

    @Bean
    public InvoiceAdaptor getInvoiceAdaptor() {
        System.out.println("Adapter created");
        return new InvoiceAdaptor();
    }

    public static void main(String args []){
        System.out.println("Server is starting");
        SpringApplication.run(Boot.class,args);
        System.out.println("Server started ...");
    }
}
