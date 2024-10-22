package com.xqf;

import com.xqf.config.People;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyRuoyiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyRuoyiApplication.class, args);


        People peoole1 = (People)run.getBean("people");
        People peoole2 = (People)run.getBean("people");

        System.out.println(peoole1 == peoole2);
    }

}
