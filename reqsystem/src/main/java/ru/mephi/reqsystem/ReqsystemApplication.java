package ru.mephi.reqsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ReqsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReqsystemApplication.class, args);
	}

}
