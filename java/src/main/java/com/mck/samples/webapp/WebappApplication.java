package com.mck.samples.webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebappApplication {

	@Value("${settings.applicationName}")
	private String applicationName;

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@RequestMapping("/hi")
	public String hi(){
		return applicationName + " Hola, soy una webapp desde un contenedor ;)";
	}
}
