package com.webank.wob.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WobCoreSpringApplicationMain {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WobCoreSpringApplicationMain.class);
        application.run();
        System.out.println("WobCoreSpringApplicationMain start success");
    }
}
