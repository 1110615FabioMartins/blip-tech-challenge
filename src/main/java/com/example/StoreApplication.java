package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(StoreApplication.class, args);
	}
}
