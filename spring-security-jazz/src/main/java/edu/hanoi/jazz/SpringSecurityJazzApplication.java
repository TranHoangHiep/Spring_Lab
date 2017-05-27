package edu.hanoi.jazz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class SpringSecurityJazzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJazzApplication.class, args);
	}
}
