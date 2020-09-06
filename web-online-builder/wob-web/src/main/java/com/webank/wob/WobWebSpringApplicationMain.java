package com.webank.wob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WobWebSpringApplicationMain {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WobWebSpringApplicationMain.class);
        application.run();
        System.out.println("WobWebSpringApplicationMain start success");
    }
}
