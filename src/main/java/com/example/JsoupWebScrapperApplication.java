package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JsoupWebScrapperApplication extends SpringBootServletInitializer {
	
	public static void main(String args[]) {
		
		//LocalDate now = LocalDate.now();
		//DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
		//String formattedNow = dateFormat.format(now); 
		
		SpringApplication.run(JsoupWebScrapperApplication.class, args);
		
		//System.out.println("output" + "_" + formattedNow + ".csv");
	}
	
	

}
