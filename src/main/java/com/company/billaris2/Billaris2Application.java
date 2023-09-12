package com.company.billaris2;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Billaris2Application {
//public class Billaris2Application implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Billaris2Application.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
